package br.com.hfn.investbe.exception;

public class DataIntegrityException extends HfnInvestException{
	
	private static final long serialVersionUID = 3326027858564621594L;

	public DataIntegrityException(String msg, boolean showMessage) {
		super(msg, showMessage);
	}
	
	public DataIntegrityException(String msg, boolean showMessage, Throwable cause) {
		super(msg,showMessage,cause);
	}
}
