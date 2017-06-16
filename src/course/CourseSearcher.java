package course;

import java.util.ArrayList;

import auth.RegistrationManager;
import entity.enrol.EnrolledCourse;
import entity.plan.PlannedCourse;
import okhttp3.OkHttpClient;

public class CourseSearcher {
	
	private OkHttpClient client;
	
	private RegistrationManager registrationManager;
	
	public CourseSearcher(OkHttpClient client, RegistrationManager registrationManager){
		this.client = client;
		this.registrationManager = registrationManager;
	}
	
	public EnrolledCourse searchCourse(String courseCode, String courseSessionCode, String sectionCode, int registrationIndex){
		return null;
		
		
		
	}

}
