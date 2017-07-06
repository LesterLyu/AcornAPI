package course;

import java.util.Map;

import com.google.gson.JsonObject;

public interface ResponseListener {
    void response(Map<String, JsonObject> data);
    void failure();
}