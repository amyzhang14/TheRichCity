package cn.amychris.therichcity.exception;

public class IllegalUserEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7050815467538616655L;

	public IllegalUserEntityException(String string){
		super(string);
	}
}
