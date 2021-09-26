package br.com.hfn.investbe.common.exception;

public class UserNotFoundException extends HfnInvestException{

	private static final long serialVersionUID = 6340690482460800743L;

	public UserNotFoundException(String msg, boolean showMessage) {
		super(msg, showMessage);
	}
	
	public UserNotFoundException(String msg, boolean showMessage, Throwable cause) {
		super(msg, showMessage, cause);
	}

}
