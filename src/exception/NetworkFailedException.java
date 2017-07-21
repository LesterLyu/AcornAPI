package exception;

public class NetworkFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NetworkFailedException(String msg){
		super(msg);
	}
	public NetworkFailedException(){
		super("Your device is not connected to Internet.");
	}
}
