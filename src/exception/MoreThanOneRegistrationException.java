package exception;

/**
 * The type More than one registration exception.
 */
public class MoreThanOneRegistrationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new More than one registration exception.
	 *
	 * @param msg the msg
	 */
	public MoreThanOneRegistrationException(String msg){
		super(msg);
	}

	/**
	 * Instantiates a new More than one registration exception.
	 */
	public MoreThanOneRegistrationException(){
		super("You need to specify the index of the registration");
	}
}
