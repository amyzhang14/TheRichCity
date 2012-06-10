package cn.amychris.therichcity.exception;

import java.util.List;

public class IllegalUserEntityException extends TheRichCityException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7050815467538616655L;

	public IllegalUserEntityException(String string) {
		super(string);
	}

	public IllegalUserEntityException(List<String> validateResult) {
		super(validateResult);
	}
}
