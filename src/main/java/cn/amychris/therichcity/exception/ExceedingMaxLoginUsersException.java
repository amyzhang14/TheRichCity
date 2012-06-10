package cn.amychris.therichcity.exception;

public class ExceedingMaxLoginUsersException extends SecurityServiceException {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7822046344551111895L;

	public ExceedingMaxLoginUsersException() {
		super();
	}
	
	public ExceedingMaxLoginUsersException(String message) {
		super(message);
	}

}
