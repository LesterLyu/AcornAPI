package auth;

import java.util.Map;

public interface InternalCallback{
	void success(Map<String, String> m);
	void failure(Exception e);
}