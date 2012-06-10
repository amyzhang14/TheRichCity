package cn.amychris.therichcity.exception;

public class UserNotfoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5969467925467646264L;
	
	public UserNotfoundException(String string)
	{
		super(string);
	}

}
