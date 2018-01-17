package course;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import auth.RegistrationManager;
import entity.enrol.EnrolledCourse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * The type Course searcher.
 */
public class CourseSearcher{
	
	private OkHttpClient client;
	
	private static OkHttpClient iitClient = new OkHttpClient.Builder().build();;
	
	private RegistrationManager registrationManager;

	/**
	 * Instantiates a new Course searcher.
	 *
	 * @param client              the client
	 * @param registrationManager the registration manager
	 */
	public CourseSearcher(OkHttpClient client, RegistrationManager registrationManager){
		this.client = client;
		this.registrationManager = registrationManager;
        this.iitClient = new OkHttpClient.Builder().build();
	}

	/**
	 * Search course enrolled course.
	 *
	 * @param courseCode        the course code
	 * @param courseSessionCode the course session code
	 * @param sectionCode       the section code
	 * @param registrationIndex the registration index
	 * @return the enrolled course
	 */
	public EnrolledCourse searchCourse(String courseCode, String courseSessionCode, String sectionCode, int registrationIndex){
		return null;
	}


	/**
	 * iit
	 *
	 * @param code the code
	 * @param r    the r
	 * @return
	 */
	public static void getCourseInfo(String code, final ResponseListener r) {

        Request request = new Request.Builder()
                .url("https://timetable.iit.artsci.utoronto.ca/api/20179/courses?code=" + code)
                .get()
                .build();

        try {
        	iitClient.newCall(request).enqueue(new Callback() {

				@Override
				public void onFailure(Call call, IOException e) {
					r.failure();
				}

				@Override
				public void onResponse(Call call, Response response) throws IOException {
					Map<String, JsonObject> courses = new HashMap<String, JsonObject>();
					JsonParser parser = new JsonParser();
					JsonObject obj = parser.parse(response.body().string()).getAsJsonObject();
					
					for(Entry<String, JsonElement> entry: obj.entrySet()){
						String courseCode = entry.getKey().substring(0, 6);
						if(courses.keySet().contains(courseCode)) 
							continue;
						courses.put(courseCode, entry.getValue().getAsJsonObject());
					}
					r.response(courses);
				}
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	

}
