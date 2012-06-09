package cn.amychris.therichcity.exception;

public class ExceedingMaxLoginUsersException extends SecurityServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceedingMaxLoginUsersException() {
		super();
	}
	
	public ExceedingMaxLoginUsersException(String message) {
		super(message);
	}

}
