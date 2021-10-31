package br.com.hfn.investbe.exception;

public class ObjectNotFoundException extends HfnInvestException{

	private static final long serialVersionUID = -850078400299086044L;
	
	public ObjectNotFoundException(String msg, boolean showMessage) {
		super(msg, showMessage);
	}
	
	public ObjectNotFoundException(String msg, boolean showMessage, Throwable cause) {
		super(msg,showMessage,cause);
	}
	

}
