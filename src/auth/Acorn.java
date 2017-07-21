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
	private String url[] = {"https://acorn.utoronto.ca/sws", 
			"https://weblogin.utoronto.ca/",
			"https://idp.utorauth.utoronto.ca/PubCookie.reply",
	"https://acorn.utoronto.ca/spACS"};

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
					public void success(Map<String, String> step1) {
						doStep2(step1, new InternalCallback() {

							@Override
							public void success(Map<String, String> loginInfo) {
								loginInfo.put("user", acornUsername);
								loginInfo.put("pass", acornPassword);
								doStep3(loginInfo, new InternalCallback() {

									@Override
									public void success(Map<String, String> step3) {
										doStep4(step3, new InternalCallback() {

											@Override
											public void success(Map<String, String> step4) {
												doStep5(step4, new InternalCallback() {

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
												sl.failure(e);
											}
										});
									}

									@Override
									public void failure(Exception e) {
										sl.failure(e);
									}
								});
							}

							@Override
							public void failure(Exception e) {
								sl.failure(e);
							}
						});
					}

					@Override
					public void failure(Exception e) {
						sl.failure(e);
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
				if(body.contains("<html>")){
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
	 * get pubcookie_g_req, post_stuff, relay_url from https://idp.utorauth.utoronto.ca/idp/Authn/RemoteUserForceAuth
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
				System.out.println(acoreCookieJar.getAllCookie());
				Map<String, String> step1 = getFormData(Jsoup.parse(response.body().string()));
				if(step1 == null)
					callback.failure(new LoginFailedException("Internet Unavailable / Unknown Error"));
				else
					callback.success(step1);
			}

		});
	}

	/**
	 * Second step
	 * get 25 params include password and username
	 * @return
	 */
	private void doStep2(Map<String, String> params, final InternalCallback callback){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[1])
				.post(formBuilder.build())
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(acoreCookieJar.getAllCookie());
				Map<String, String> step2 = getFormData(Jsoup.parse(response.body().string()));
				if(step2 == null)
					callback.failure(new LoginFailedException("Internet Unavailable / Unknown Error"));
				else
					callback.success(step2);
			}

		});
	}

	/**
	 * Third Step - do log in
	 */
	private void doStep3(Map<String, String> params, final InternalCallback callback){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[1])
				.post(formBuilder.build())
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(acoreCookieJar.getAllCookie());
				String body = response.body().string();
				if(body.contains("Authentication failed."))
					callback.failure(new LoginFailedException());
				Map<String, String> res = getFormData(Jsoup.parse(body));
				if(res == null)
					callback.failure(new LoginFailedException("Internet Unavailable / Unknown Error"));
				else
					callback.success(res);
			}

		});
	}

	/**
	 * 4th Step
	 */
	private void doStep4(Map<String, String> params, final InternalCallback callback){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[2])
				.post(formBuilder.build())
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(acoreCookieJar.getAllCookie());
				String body = response.body().string();
				Map<String, String> res = getFormData(Jsoup.parse(body));
				if(res == null)
					callback.failure(new LoginFailedException("Internet Unavailable / Unknown Error"));
				else
					callback.success(res);
			}

		});
	}

	/**
	 * 5th Step - final login, return true if success
	 */
	private void doStep5(Map<String, String> params, final InternalCallback callback){
		FormBody.Builder formBuilder = new FormBody.Builder();
		for(String key: params.keySet()){
			formBuilder.add(key, params.get(key));
		}
		Request request = new Request.Builder()
				.url(url[3])
				.post(formBuilder.build())
				.build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				callback.failure(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(acoreCookieJar.getAllCookie());
				String body = response.body().string();
				System.out.println(body);
				if(body.contains("<title>ACORN</title>"))
					callback.success(null);
				else
					callback.failure(new LoginFailedException("Acorn Unavailable"));
			}

		});
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

