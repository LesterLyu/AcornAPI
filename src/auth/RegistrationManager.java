package auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import exception.LoginFailedException;
import exception.MoreThanOneRegistrationException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegistrationManager {

	private OkHttpClient client;

	JsonArray registrationsArray;

	public RegistrationManager(OkHttpClient client) {
		this.client = client;
	}

	public List<String> getEligibleRegistrations() throws LoginFailedException{
		System.out.println("Requesting Eligible Registrations...");
		// https://acorn.utoronto.ca/sws/rest/enrolment/eligible-registrations
		Request request = new Request.Builder()
				.url("https://acorn.utoronto.ca/sws/rest/enrolment/eligible-registrations")
				.get()
				.build();
		try {
			Response response = client.newCall(request).execute();
			String eligibleRegistrationsJson = response.body().string();
			// check error
			if(eligibleRegistrationsJson.contains("Error")) {
				throw new LoginFailedException("getEligibleRegistrations: " + eligibleRegistrationsJson);
			}
			
			System.out.println(eligibleRegistrationsJson);
			// parse the readable string
			JsonParser parser = new JsonParser();
			registrationsArray = parser.parse(eligibleRegistrationsJson).getAsJsonArray();
			List<String> output = new ArrayList<String>();
			for(JsonElement nextRegistration: registrationsArray){
				output.add(Jsoup.parse(nextRegistration.getAsJsonObject().get("post").getAsJsonObject().get("description").getAsString() + "(" +
						nextRegistration.getAsJsonObject().get("candidacyPostCode").getAsString() + ") " +
						nextRegistration.getAsJsonObject().get("sessionDescription").getAsString()).text());
			}
			System.out.println(output);
			return output;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int getNumberOfRegistrations() throws LoginFailedException{
		if(registrationsArray == null)
			getEligibleRegistrations();
		return registrationsArray.size();
	}


	public JsonObject getRegistrationParams() throws LoginFailedException{
		if(registrationsArray == null)
			getEligibleRegistrations();
		if(registrationsArray.size() > 1)
			throw new MoreThanOneRegistrationException();
		return getRegistrationParams(0);
	}

	public JsonObject getRegistrationParams(int index) throws LoginFailedException{
		if(registrationsArray == null)
			getEligibleRegistrations();
		 return registrationsArray.get(index).getAsJsonObject();
	}

}
