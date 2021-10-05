package br.com.hfn.investbe.common.exception;

public class InvalidUserAuthenticationException extends HfnInvestException{

	private static final long serialVersionUID = 5207050717769668971L;
	
	public InvalidUserAuthenticationException(String msg, boolean showMessage) {
		super(msg, showMessage);
	}
	
	public InvalidUserAuthenticationException(String msg, boolean showMessage, Throwable cause) {
		super(msg, showMessage, cause);
	}

}
