package auth;

import java.io.IOException;
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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class Acorn {
	private OkHttpClient client;
	private String acornUsername;
	private String acornPassword;
	private AcornCookieJar acoreCookieJar;
	private CourseManager courseManager;
	private RegistrationManager registrationManager;
	private GradeManager gradeManager;
	private String url[] = {"https://acorn.utoronto.ca/sws"};

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

	public void refresh() {
		acoreCookieJar = new AcornCookieJar();
		this.client = new OkHttpClient.Builder()
				.cookieJar(acoreCookieJar)
				.build();
		registrationManager = new RegistrationManager(client);
		courseManager = new CourseManager(client, registrationManager);
		gradeManager = new GradeManager(client);
		//this.doLogin();
	}

	public OkHttpClient getHttpClient(){
		return client;
	}

	public CourseManager getCourseManager(){
		return courseManager;
	}

	public RegistrationManager getRegistrationManager(){
		return registrationManager;
	}

	public GradeManager getGradeManager(){
		return gradeManager;
	}

	/**
	 * Try to login
	 * @return true if login success
	 * @throws LoginFailedException if problem occurs
	 */
	public void doLogin(final SimpleListener sl){

		isLoggedIn(new SimpleListener(){

			@Override
			public void success() {
				sl.success();
			}

			@Override
			public void failure(Exception e) {
				refresh();
				doStep1(new InternalCallback() {

					@Override
					public void success(Map<String, String> loginInfo) {

						loginInfo.put("j_username", acornUsername);
						loginInfo.put("j_password", acornPassword);
						doStep2(loginInfo, new InternalCallback() {

							@Override
							public void success(Map<String, String> redirectToAcorn ) {

								doStep3(redirectToAcorn , new InternalCallback() {

									@Override
									public void success(Map<String, String> m) {
										sl.success();
									}

									@Override
									public void failure(Exception e) {
										sl.failure(e);
									}
								});
							}
							
							@Override
							public void failure(Exception e) {
							}
						});
					}
					
					@Override
					public void failure(Exception e) {
						// TODO Auto-generated method stub
					}
				});
			}
		});
	}


	public void isLoggedIn(final SimpleListener sl){

		final Request request = new Request.Builder()
				.url("https://acorn.utoronto.ca/sws/rest/profile/studentBasicInfo")
				.get()
				.build();
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				sl.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String body = response.body().string();
				if(body.contains("weblogin idpz")){
					sl.failure(null);
				}
				else
					sl.success();
			}
		});
	}


	public boolean isSameUserPass(String user, String pass){
		return acornUsername.equals(user) && acornPassword.equals(pass);
	}


	/**
	 * First step,
	 * get params from https://idpz.utorauth.utoronto.ca/idp/profile/SAML2/Redirect/SSO
	 * @return the Map of them
	 */
	public void doStep1(final InternalCallback callback){
		Request request = new Request.Builder()
				.url(url[0])
				.get()
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Map<String, String> step1 = getFormData(Jsoup.parse(response.body().string()), false);
				if(step1 == null)
					callback.failure(new LoginFailedException("Internet Unavailable / Unknown Error"));
				else {
					step1.put("_eventId_proceed", ""); // must have this field!
					step1.put("new-url", response.request().url().toString());
					callback.success(step1);
				}
			}
		});
	}

	/**
	 * Second step
	 * Log in with username / password, supposed to get SAMLResponse
	 * @return
	 */
	private void doStep2(Map<String, String> params, final InternalCallback callback){
		System.out.println(params);
		String newUrl = params.remove("new-url");
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(newUrl)
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.post(formBuilder.build())
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String body = response.body().string();
				Map<String, String> step2 = getFormData(Jsoup.parse(body), true);
				// Error
				if(!step2.keySet().contains("SAMLResponse")) {
					// parse error
					Document doc = Jsoup.parse(body);
					Elements errors = doc.select("p.form-error");
					if(errors.size() > 1) {
						callback.failure(new LoginFailedException(errors.get(0).html()));
					}
					callback.failure(new LoginFailedException(errors.html()));
				}
				// Otherwise, success
				callback.success(step2);
			}

		});
	}

	/**
	 * 3th Step - final login, send SAMLRespons, return true if success
	 */
	private void doStep3(Map<String, String> params, final InternalCallback callback){
		System.out.println(params);
		String newUrl = params.remove("new-action");
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(newUrl)
				.post(formBuilder.build())
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				if(response.body().string().contains("<title>ACORN</title>"))
					callback.success(null);
				else
					callback.failure(new LoginFailedException("Acorn Unavailable"));
			}

		});
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

