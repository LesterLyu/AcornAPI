package exception;

/**
 * The type Login failed exception.
 */
public class LoginFailedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Login failed exception. The constructor takes the argument msg to provide user
	 * the message for exception.
	 *
	 * @param msg the msg
	 */
	public LoginFailedException(String msg){
		super(msg);
	}

	/**
	 * Instantiates a new Login failed exception. The constructor is empty with a hard coded exception message.
	 */
	public LoginFailedException(){
		super("Username or password does not match");
	}
}
