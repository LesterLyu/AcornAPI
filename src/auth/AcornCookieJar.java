package auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class AcornCookieJar  implements CookieJar{

	private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		//System.out.println("saveFromResponse:\n" + cookies);
		if(cookieStore.containsKey(url.host())){
			List<Cookie> cookieList = cookieStore.get(url.host());
			for(Cookie c: cookies) {
				// expire the cookie
				if(!(c.expiresAt() < System.currentTimeMillis()))
					cookieList.add(c);
			}
		}
		else{
			cookieStore.put(url.host(), new ArrayList<Cookie>());
			cookieStore.get(url.host()).addAll(cookies);
		}
	}

	public List<Cookie> loadForRequest(HttpUrl url) {
		List<Cookie> cookies = cookieStore.get(url.host());
		return cookies != null ? cookies : new ArrayList<Cookie>();

	}

	/**
	 * for self test
	 * @return
	 */
	public Map<String, List<Cookie>> getAllCookie(){
		return cookieStore;
	}
}
