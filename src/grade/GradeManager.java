package grade;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * The type Grade manager.
 *
 * @author Lester Lyu
 */
public class GradeManager {

	private OkHttpClient client;

	/**
	 * Instantiates a new Grade manager.
	 *
	 * @param client the client
	 */
	public GradeManager(OkHttpClient client){
		this.client = client;
	}

	/**
	 * The method retrieves the HTML string of the academic history page of ACORN of University of Toronto students.
	 * It parses the requested HTML produces the corresponding Document object and then converts it into string.
	 * If the request is fulfilled it returns the HTML string otherwise returns the "N/A"
	 *
	 * @return the string
	 */
	public String getGradeHtml(){
		// https://acorn.utoronto.ca/sws/transcript/academic/main.do?main.dispatch&mode=complete
		Request request = new Request.Builder()
				.url("https://acorn.utoronto.ca/sws/transcript/academic/main.do?main.dispatch&mode=complete")
				.get()
				.build();
		try {
			Response response = client.newCall(request).execute();
			String html = response.body().string();
			Document doc = Jsoup.parse(html);
			//System.out.println(html);
			String res = doc.select("[class=academic-history-report row]").html();
			//res = Jsoup.parse(res).text();
			return res;
			
		} catch(Exception e){
			e.printStackTrace();
		}

		return "N/A";
	}
	
	

}
