package exception;

public class MoreThanOneRegistrationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public MoreThanOneRegistrationException(String msg){
		super(msg);
	}
	public MoreThanOneRegistrationException(){
		super("You need to specify the index of the registration");
	}
}
