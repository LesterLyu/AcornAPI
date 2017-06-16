package exception;

public class LoginFailedException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LoginFailedException(String msg){
		super(msg);
	}
	public LoginFailedException(){
		super("Username or password does not match");
	}
}
