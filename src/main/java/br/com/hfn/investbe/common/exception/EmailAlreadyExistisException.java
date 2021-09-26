package br.com.hfn.investbe.common.exception;

public class EmailAlreadyExistisException extends HfnInvestException{

	private static final long serialVersionUID = -6270199989995818090L;
	
	public EmailAlreadyExistisException(String msg, boolean showMessage) {
		super(msg,showMessage);
	}
	
	public EmailAlreadyExistisException(String msg, boolean showMessage, Throwable cause) {
		super(msg,showMessage,cause);
	}
	

}
