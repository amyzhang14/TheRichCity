package cn.amychris.therichcity.exception;

import java.util.List;

public class CommandExecutingException extends TheRichCityException {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public CommandExecutingException(List<String> localizedMessages) {
		super( localizedMessages );
	}

	public CommandExecutingException(String msg) {
		super( msg );
	}

	public CommandExecutingException(Exception e) {
		super( e );
	}

}
