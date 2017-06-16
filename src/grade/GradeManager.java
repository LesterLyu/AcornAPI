package grade;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * @author Lester Lyu
 *
 */
public class GradeManager {

	private OkHttpClient client;

	public GradeManager(OkHttpClient client){
		this.client = client;
	}

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
