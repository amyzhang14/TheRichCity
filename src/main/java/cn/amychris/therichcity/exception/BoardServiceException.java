package cn.amychris.therichcity.exception;

import java.util.List;

public class BoardServiceException extends TheRichCityException {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public BoardServiceException(Exception e) {
		super( e );
	}

	public BoardServiceException(List<String> localizedMessages) {
		super( localizedMessages );
	}
	
	public BoardServiceException(String msg) {
		super( msg);
	}

}
