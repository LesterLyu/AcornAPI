package course;

import java.util.Map;

import com.google.gson.JsonObject;

/**
 * The interface Response listener.
 */
public interface ResponseListener {
    /**
     * Response.
     *
     * @param data the data
     */
    void response(Map<String, JsonObject> data);

    /**
     * Failure.
     */
    void failure();
}