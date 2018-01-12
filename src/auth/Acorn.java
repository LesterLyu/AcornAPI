package auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.Connection.KeyVal;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

import course.CourseManager;
import exception.LoginFailedException;
import grade.GradeManager;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * The type Acorn.
 */
public class Acorn {
	private OkHttpClient client;
	private String acornUsername;
	private String acornPassword;
	private AcornCookieJar acoreCookieJar;
	private CourseManager courseManager;
	private RegistrationManager registrationManager;
	private GradeManager gradeManager;
	private String url[] = {"https://acorn.utoronto.ca/sws", 
			"https://weblogin.utoronto.ca/",
			"https://idp.utorauth.utoronto.ca/PubCookie.reply",
			"https://acorn.utoronto.ca/spACS"};

	/**
	 * Instantiates a new Acorn.
	 *
	 * @param acornUsername the acorn username
	 * @param acornPassword the acorn password
	 */
	public Acorn(String acornUsername, String acornPassword) {
		this.acornUsername = acornUsername;
		this.acornPassword = acornPassword;
		acoreCookieJar = new AcornCookieJar();
		this.client = new OkHttpClient.Builder()
				.cookieJar(acoreCookieJar)
				.build();
		registrationManager = new RegistrationManager(client);
		courseManager = new CourseManager(client, registrationManager);
		gradeManager = new GradeManager(client);

	}

	/**
	 * Refresh.
	 *
	 * @throws LoginFailedException the login failed exception
	 */
	public void refresh() throws LoginFailedException{
		acoreCookieJar = new AcornCookieJar();
		this.client = new OkHttpClient.Builder()
				.cookieJar(acoreCookieJar)
				.build();
		registrationManager = new RegistrationManager(client);
		courseManager = new CourseManager(client, registrationManager);
		gradeManager = new GradeManager(client);
		this.doLogin();
	}

	/**
	 * Get http client ok http client.
	 *
	 * @return the ok http client
	 */
	public OkHttpClient getHttpClient(){
		return client;
	}

	/**
	 * Get course manager course manager.
	 *
	 * @return the course manager
	 */
	public CourseManager getCourseManager(){
		return courseManager;
	}

	/**
	 * Get registration manager registration manager.
	 *
	 * @return the registration manager
	 */
	public RegistrationManager getRegistrationManager(){
		return registrationManager;
	}

	/**
	 * Get grade manager grade manager.
	 *
	 * @return the grade manager
	 */
	public GradeManager getGradeManager(){
		return gradeManager;
	}

	/**
	 * Try to login
	 *
	 * @return true if login success
	 * @throws LoginFailedException if problem occurs
	 */
	public boolean doLogin() throws LoginFailedException{
		Map<String, String> step1 = doStep1();
		if(step1 == null)
			return false;
		Map<String, String> loginInfo = doStep2(step1);
		loginInfo.put("user", acornUsername);
		loginInfo.put("pass", acornPassword);
		Map<String, String> step3 = doStep3(loginInfo);
		Map<String, String> step4 = doStep4(step3);
		boolean result = doStep5(step4);
		System.out.println(result);
		return true;
	}
	
	/**
	 * First step,
	 * get pubcookie_g_req, post_stuff, relay_url from https://idp.utorauth.utoronto.ca/idp/Authn/RemoteUserForceAuth
	 * @return the Map of them
	 */
	private Map<String, String> doStep1(){
		Request request = new Request.Builder()
				.url(url[0])
				.get()
				.build();
		try {
			Response response = client.newCall(request).execute();
			Map<String, String> res = getFormData(Jsoup.parse(response.body().string()));
			return res;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Second step
	 * get 25 params include password and username
	 * @return
	 */
	private Map<String, String> doStep2(Map<String, String> params){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[1])
				.post(formBuilder.build())
				.build();
		try {
			Response response = client.newCall(request).execute();
			Map<String, String> res = getFormData(Jsoup.parse(response.body().string()));
			return res;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Third Step - do log in
	 */
	private Map<String, String> doStep3(Map<String, String> params){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[1])
				.post(formBuilder.build())
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.build();
		try {
			Response response = client.newCall(request).execute();
			String body = response.body().string();
			if(body.contains("Authentication failed."))
				throw new LoginFailedException();
			Map<String, String> res = getFormData(Jsoup.parse(body));
			return res;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 4th Step
	 */
	private Map<String, String> doStep4(Map<String, String> params){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[2])
				.post(formBuilder.build())
				.build();
		try {
			Response response = client.newCall(request).execute();
			Map<String, String> res = getFormData(Jsoup.parse(response.body().string()));
			return res;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 5th Step - final login, return true if success
	 */
	private boolean doStep5(Map<String, String> params){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[3])
				.post(formBuilder.build())
				.build();
		try {
			Response response = client.newCall(request).execute();
			if(response.body().string().contains("<title>ACORN</title>")){
				return true;
			}
			else{
				throw new LoginFailedException("Acorn Unavailable");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * Give a Document, parse it and return all form data.
	 * 
	 * @param doc
	 * @return null if this Document has more than one form or does not have form
	 */
	private static Map<String, String> getFormData(Document doc){
		Elements formElements = doc.getElementsByTag("form");
		if(formElements.size() != 1)
			return null;
		List<FormElement> forms = formElements.forms();
		List<KeyVal> data = forms.get(0).formData();
		HashMap<String, String> map = new HashMap<String, String>();
		for(KeyVal kv: data){
			map.put(kv.key(), kv.value());
		}
		return map;
	}

}

