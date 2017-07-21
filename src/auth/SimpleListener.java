package auth;

public interface SimpleListener {
    void success();
    void failure(Exception e);
}