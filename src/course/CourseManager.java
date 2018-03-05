package course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import auth.AcornCookieJar;
import auth.RegistrationManager;
import entity.enrol.EnrolledCourse;
import entity.enrol.Meeting;
import entity.plan.PlannedCourse;
import exception.LoginFailedException;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 * @author Lester Lyu
 *
 */
public class CourseManager {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	private OkHttpClient client;

	private RegistrationManager registrationManager;
	
	public String lastErrorMsg = "N/A";

	/**
	 * includes enrolled courses and waiting listed courses and dropped(late withdraw) courses
	 */
	private List<EnrolledCourse> appliedCourses;

	/**
	 * courses that are in enrollment cart
	 */
	private  List<PlannedCourse> plannedCourses;


	public CourseManager(OkHttpClient client, RegistrationManager registrationManager){
		this.client = client;
		this.registrationManager = registrationManager;
		appliedCourses = new ArrayList<EnrolledCourse>();
		plannedCourses = new ArrayList<PlannedCourse>();
	}

	/**
	 * load courses from all registrations
	 * Note:
	 * UTSC separate 1 year into two registrations, UTSG has only one registration per year,
	 * for UTM idk.
	 * @throws LoginFailedException 
	 */
	public void loadCourses() throws LoginFailedException{
		for(int i = 0; i < registrationManager.getNumberOfRegistrations(); i++){
			loadEnrolledCourses(i);
			loadPlannedCourse(i);
		}
	}

	private void loadEnrolledCourses(int registrationIndex) throws LoginFailedException{
		JsonObject registionParams = registrationManager.getRegistrationParams(registrationIndex)
				.get("registrationParams").getAsJsonObject();
		//System.out.println(registionParams);
		HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host("acorn.utoronto.ca")
				.addPathSegments("sws/rest/enrolment/course/enrolled-courses")
				.addQueryParameter("postCode", registionParams.get("postCode").getAsString())
				.addQueryParameter("postDescription", registionParams.get("postDescription").getAsString())
				.addQueryParameter("sessionCode", registionParams.get("sessionCode").getAsString())
				.addQueryParameter("sessionDescription", registionParams.get("sessionDescription").getAsString())
				.addQueryParameter("status", registionParams.get("status").getAsString())
				.addQueryParameter("assocOrgCode", registionParams.get("assocOrgCode").getAsString())
				.addQueryParameter("acpDuration", registionParams.get("acpDuration").getAsString())
				.addQueryParameter("levelOfInstruction", registionParams.get("levelOfInstruction").getAsString())
				.addQueryParameter("typeOfProgram", registionParams.get("typeOfProgram").getAsString())
				.addQueryParameter("designationCode1", registionParams.get("designationCode1").getAsString())
				.addQueryParameter("primaryOrgCode", registionParams.get("primaryOrgCode").getAsString())
				.addQueryParameter("secondaryOrgCode", registionParams.get("secondaryOrgCode").getAsString())
				.addQueryParameter("collaborativeOrgCode", registionParams.get("collaborativeOrgCode").getAsString())
				.addQueryParameter("adminOrgCode", registionParams.get("adminOrgCode").getAsString())
				.addQueryParameter("coSecondaryOrgCode", registionParams.get("coSecondaryOrgCode").getAsString())
				.addQueryParameter("yearOfStudy", registionParams.get("yearOfStudy").getAsString())
				.addQueryParameter("postAcpDuration", registionParams.get("postAcpDuration").getAsString())
				.build();

		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();

		try {
			Response response = client.newCall(request).execute();

			String appliedCourseJson = response.body().string();
			//System.out.println(appliedCourseJson);
			Gson gson = new Gson();

			if(!appliedCourseJson.equals("{}")) {
				// process json
				JsonParser parser = new JsonParser();
				JsonObject courseJsonObject = parser.parse(appliedCourseJson).getAsJsonObject();
				
				List<EnrolledCourse> enrolledCourseList;
				List<EnrolledCourse> waitlistedCourseList;
				List<EnrolledCourse> droppedCourseList;
				
				// enrolled course
				if(courseJsonObject.has("APP")){
					JsonArray jsonArrayAPP = courseJsonObject.get("APP").getAsJsonArray();
					enrolledCourseList = gson.fromJson(jsonArrayAPP.toString(),
							new TypeToken<List<EnrolledCourse>>(){}.getType());
					appliedCourses.addAll(enrolledCourseList);
				}
				// wait listed course
				if(courseJsonObject.has("WAIT")) {
					// for waitlisted course, I need to get more info from 
					// https://acorn.utoronto.ca/sws/rest/enrolment/course/view
					// i.e. wait list rank, etc
					
					JsonArray jsonArrayWAIT = courseJsonObject.get("WAIT").getAsJsonArray();
					waitlistedCourseList = gson.fromJson(jsonArrayWAIT.toString(), new TypeToken<List<EnrolledCourse>>(){}.getType());
					// get courseCode and sectionCode
					for(EnrolledCourse nextCourse: waitlistedCourseList){
						String courseCode = nextCourse.getCode();
						String courseSessionCode = nextCourse.getSessionCode();
						String sectionCode = nextCourse.getSectionCode();
						// load extra info but still the same object type
						EnrolledCourse newCourse = loadExtraInfo(courseCode, courseSessionCode, sectionCode, registrationIndex);
						System.out.println(newCourse);
						appliedCourses.add(newCourse);
					}
					
				}
				if(courseJsonObject.has("DROP")) {
					JsonArray jsonArrayDROP = courseJsonObject.get("DROP").getAsJsonArray();
					droppedCourseList = gson.fromJson(jsonArrayDROP.toString(), new TypeToken<List<EnrolledCourse>>(){}.getType());
					appliedCourses.addAll(droppedCourseList);
				}
				
				Collections.sort(appliedCourses, new Comparator<EnrolledCourse>() {
                    @Override
                    public int compare(EnrolledCourse o1, EnrolledCourse o2) {
                        if(o1.getSectionCode().equalsIgnoreCase("S") && (o2.getSectionCode().equalsIgnoreCase("Y") || o2.getSectionCode().equalsIgnoreCase("F")))
                            return 1;
                        else if(o1.getSectionCode().equalsIgnoreCase("Y") && o2.getSectionCode().equalsIgnoreCase("F"))
                            return 1;
                        else if(!o1.getSectionCode().equalsIgnoreCase(o2.getSectionCode()))
                            return -1;
                        else{
                            return o1.getCode().compareToIgnoreCase(o2.getCode());
                        }
                    }
                });				
			}

		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * For waitlisted course to get waiting list rank 
	 * AND
	 * For searching a course info, even though not enrolled or waiting listed yet.
	 * @return a complete EnrolledCourse
	 * @throws LoginFailedException 
	 */
	private EnrolledCourse loadExtraInfo(String courseCode, String courseSessionCode, String sectionCode, int registrationIndex) throws LoginFailedException{
		JsonObject registionParams = registrationManager.getRegistrationParams(registrationIndex)
				.get("registrationParams").getAsJsonObject();
		//System.out.println(registionParams);
		HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host("acorn.utoronto.ca")
				.addPathSegments("sws/rest/enrolment/course/view")
				.addQueryParameter("acpDuration", registionParams.get("acpDuration").getAsString())
				.addQueryParameter("activityApprovedInd", "")
				.addQueryParameter("activityApprovedOrg", "")
				.addQueryParameter("adminOrgCode", registionParams.get("adminOrgCode").getAsString())
				.addQueryParameter("assocOrgCode", registionParams.get("assocOrgCode").getAsString())
				.addQueryParameter("coSecondaryOrgCode", registionParams.get("coSecondaryOrgCode").getAsString())
				.addQueryParameter("collaborativeOrgCode", registionParams.get("collaborativeOrgCode").getAsString())
				.addQueryParameter("courseCode", courseCode)
				.addQueryParameter("courseSessionCode", courseSessionCode)
				.addQueryParameter("designationCode1", registionParams.get("designationCode1").getAsString())
				.addQueryParameter("levelOfInstruction", registionParams.get("levelOfInstruction").getAsString())
				.addQueryParameter("postAcpDuration", registionParams.get("postAcpDuration").getAsString())
				.addQueryParameter("postCode", registionParams.get("postCode").getAsString())
				.addQueryParameter("postDescription", registionParams.get("postDescription").getAsString())
				.addQueryParameter("primaryOrgCode", registionParams.get("primaryOrgCode").getAsString())
				.addQueryParameter("secondaryOrgCode", registionParams.get("secondaryOrgCode").getAsString())
				.addQueryParameter("sectionCode", sectionCode)
				.addQueryParameter("sessionCode", registionParams.get("sessionCode").getAsString())
				.addQueryParameter("sessionDescription", registionParams.get("sessionDescription").getAsString())
				.addQueryParameter("status", registionParams.get("status").getAsString())
				.addQueryParameter("subjectCode1", registionParams.get("subjectCode1").getAsString())
				.addQueryParameter("typeOfProgram", registionParams.get("typeOfProgram").getAsString())
				.addQueryParameter("useSws", registionParams.get("useSws").getAsString())
				.addQueryParameter("yearOfStudy", registionParams.get("yearOfStudy").getAsString())
				.build();

		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();
		try {
			Response response = client.newCall(request).execute();

			String courseJson = response.body().string();
			System.out.println(courseJson);
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject courseJsonObject = parser.parse(courseJson).getAsJsonObject().get("responseObject").getAsJsonObject();
			return gson.fromJson(courseJsonObject, EnrolledCourse.class);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 
	 * @param courseCode CSC343H1
	 * @param courseSessionCode 20171
	 * @param sectionCode S
	 * @param registrationIndex 0
	 * @return
	 * @throws LoginFailedException 
	 */
	public String getCourseSpace(String courseCode, String courseSessionCode, String sectionCode, int registrationIndex) throws LoginFailedException{
		EnrolledCourse course = loadExtraInfo(courseCode, courseSessionCode, sectionCode, registrationIndex);
		String spaceInfo = courseCode + sectionCode + " Space: ";
		for(Meeting meeting: course.getMeetings()){
			spaceInfo += meeting.getDisplayName() + ": " + meeting.getEnrollmentSpaceAvailable() + "/" +  meeting.getEnrollSpace() + ", ";
		}
		spaceInfo = spaceInfo.substring(0, spaceInfo.length() - 2);
		return spaceInfo;
	}
	
	
	private void loadPlannedCourse(int registrationIndex) throws LoginFailedException{
		// https://acorn.utoronto.ca/sws/rest/enrolment/plan?candidacyPostCode=ASPRGHBSC&candidacySessionCode=20169&sessionCode=20169
		JsonObject registionParams = registrationManager.getRegistrationParams(registrationIndex).getAsJsonObject();
		//System.out.println(registionParams);
		HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host("acorn.utoronto.ca")
				.addPathSegments("sws/rest/enrolment/plan")
				.addQueryParameter("candidacyPostCode", registionParams.get("candidacyPostCode").getAsString())
				.addQueryParameter("candidacySessionCode", registionParams.get("candidacySessionCode").getAsString())
				.addQueryParameter("sessionCode", registionParams.get("sessionCode").getAsString())
				.build();

		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();

		try {
			Response response = client.newCall(request).execute();

			String plannedCourseJson = response.body().string();
			//System.out.println("Planned courses: " + plannedCourseJson);
			Gson gson = new Gson();
			
			// cannot be empty json array
            if(!plannedCourseJson.equals("[]")) {
            	List<PlannedCourse> plannedCourseList = gson.fromJson(plannedCourseJson.toString(),
                		new TypeToken<List<PlannedCourse>>(){}.getType());
                plannedCourses.addAll(plannedCourseList);
                
                
                Collections.sort(plannedCourses, new Comparator<PlannedCourse>() {
                    @Override
                    public int compare(PlannedCourse o1, PlannedCourse o2) {
                        if(o1.getSectionCode().equalsIgnoreCase("S") && (o2.getSectionCode().equalsIgnoreCase("Y") || o2.getSectionCode().equalsIgnoreCase("F")))
                            return 1;
                        else if(o1.getSectionCode().equalsIgnoreCase("Y") && o2.getSectionCode().equalsIgnoreCase("F"))
                            return 1;
                        else if(!o1.getSectionCode().equalsIgnoreCase(o2.getSectionCode()))
                            return -1;
                        else{
                            return o1.getCourseCode().compareToIgnoreCase(o2.getCourseCode());
                        }
                    }
                });
            }


		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public List<EnrolledCourse> getAppliedCourses() throws LoginFailedException{
		if(appliedCourses.size() == 0)
			loadCourses();
		return appliedCourses;
	}
	
	public List<PlannedCourse> getPlannedCourses(){
		return plannedCourses;
	}
	
	public void refresh() throws LoginFailedException{
		appliedCourses = new ArrayList<EnrolledCourse>();
		plannedCourses = new ArrayList<PlannedCourse>();
		loadCourses();
	}
	
	/**
	 * normally registrationIndex=1 is summer
	 * {"course":{"code":"CSC236H1","sectionCode":"Y","primaryTeachMethod":"LEC","enroled":false},"lecture":{"sectionNo":"LEC,5101"},"tutorial":{},"practical":{}}
	 * @param registrationIndex
	 * @throws LoginFailedException 
	 */
	public boolean enroll(int registrationIndex, String code, String sectionCode, String lectureSectionNo) throws LoginFailedException{
		JsonObject registionParams = registrationManager.getRegistrationParams(registrationIndex)
				.get("registrationParams").getAsJsonObject();
		
		JsonObject course = new JsonObject();
		course.addProperty("code", code.toUpperCase());
		course.addProperty("sectionCode", sectionCode.toUpperCase());
		course.addProperty("primaryTeachMethod", "LEC");
		course.addProperty("enroled", "false");
		
		JsonObject lecture = new JsonObject();
		lecture.addProperty("sectionNo", lectureSectionNo.toUpperCase());
		
		JsonObject activeCourse = new JsonObject();
		activeCourse.add("course", course);
		activeCourse.add("lecture", lecture);
		activeCourse.add("tutorial", new JsonObject());
		activeCourse.add("practical", new JsonObject());
		
		JsonObject requestBody = new JsonObject();
		requestBody.add("activeCourse", activeCourse);
		requestBody.add("eligRegParams", registionParams);
		
		RequestBody body = RequestBody.create(JSON, requestBody.toString());
		
		AcornCookieJar cookieJar = (AcornCookieJar) client.cookieJar();
		String token = "";
		
		for(Cookie c: cookieJar.getAllCookie().get("acorn.utoronto.ca")){
			if(c.name().equalsIgnoreCase("XSRF-TOKEN")){
				token = c.value();
			}
		}
		

		Request request = new Request.Builder()
				.url("https://acorn.utoronto.ca/sws/rest/enrolment/course/modify")
				.post(body)
				.header("X-XSRF-TOKEN", token)
				.build();

		try {
			Response response = client.newCall(request).execute();
			String result = response.body().string();
			System.out.println("status code: " + response.code() + " return value: " + result);
			if(response.code() == 500){
				lastErrorMsg = result;
				return false;
			}
			else if(response.code() == 200)
				return true;
				
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
}
