package cn.amychris.therichcity.exception;

import java.util.ArrayList;
import java.util.List;

public class TheRichCityException extends RuntimeException {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3085820369966896193L;
	
	private List<String> localizedMessages;
	
	public TheRichCityException(List<String> localizedMessages) {
		super();
		this.localizedMessages = localizedMessages;
	}
	
	public TheRichCityException(String msg) {
		super();
		localizedMessages = new ArrayList<String>();
		localizedMessages.add(msg);
	}

	public TheRichCityException(Exception e) {
		super(e);
	}

	public List<String> getLocalizedMessages() {;
		return localizedMessages;
	}
}
