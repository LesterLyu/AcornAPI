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
	private String url[] = {"https://acorn.utoronto.ca/sws"};

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
		Map<String, String> loginInfo = doStep1();
		if(loginInfo == null)
			return false;
		loginInfo.put("j_username", acornUsername);
		loginInfo.put("j_password", acornPassword);
		Map<String, String> redirectToAcorn = doStep2(loginInfo);
		boolean result = doStep3(redirectToAcorn);
		System.out.println(result);
		return true;
	}
	
	/**
	 * First step,
	 * get params from https://idpz.utorauth.utoronto.ca/idp/profile/SAML2/Redirect/SSO
	 * @return the Map of them
	 */
	private Map<String, String> doStep1(){
		Request request = new Request.Builder()
				.url(url[0])
				.get()
				.build();
		try {
			Response response = client.newCall(request).execute();
			String body = response.body().string();
			Map<String, String> res = getFormData(Jsoup.parse(body), false);
			res.put("_eventId_proceed", ""); // must have this field!
			res.put("new-url", response.request().url().toString());
			return res;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Log in with username / password, supposed to get SAMLResponse
	 * @param params
	 * @return
	 */
	private Map<String, String> doStep2(Map<String, String> params) {
		String newUrl = params.remove("new-url");
		System.out.println(params);
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(newUrl)
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.post(formBuilder.build())
				.build();
		try {
			Response response = client.newCall(request).execute();
			String body = response.body().string();
			Map<String, String> res = getFormData(Jsoup.parse(body), true);
			// Error
			if(!res.keySet().contains("SAMLResponse")) {
				// parse error
				Document doc = Jsoup.parse(body);
				Elements errors = doc.select("p.form-error");
				if(errors.size() > 1) {
					throw new LoginFailedException(errors.get(0).html());
				}
				throw new LoginFailedException(errors.html());
			}
			// Otherwise, success
			return res;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 5th Step - final login, send SAMLRespons, return true if success
	 */
	private boolean doStep3(Map<String, String> params){
		String newUrl = params.remove("new-action");
		
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(newUrl)
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
	 * @param doc: HTML document
	 * @param includeAction: if include the action attribute in the form 
	 * @return null if this Document has more than one form or does not have form
	 */
	private static Map<String, String> getFormData(Document doc, boolean includeAction){
		Elements formElements = doc.getElementsByTag("form");
		if(formElements.size() != 1)
			return null;
		List<FormElement> forms = formElements.forms();
		List<KeyVal> data = forms.get(0).formData();
		HashMap<String, String> map = new HashMap<String, String>();
		for(KeyVal kv: data){
			map.put(kv.key(), kv.value());
		}
		if(includeAction)
			map.put("new-action", formElements.attr("action"));
		return map;
	}

}

