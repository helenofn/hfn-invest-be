package br.com.hfn.investbe.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HfnInvestException extends RuntimeException{

	private static final long serialVersionUID = 4530018982793712700L;
	
	private boolean showMessage = false;
	
	public HfnInvestException(String msg, boolean showMessage) {
		super(msg);
		this.showMessage = showMessage;
	}
	
	public HfnInvestException(String msg, boolean showMessage, Throwable cause) {
		super(msg,cause);
	}
	
}
