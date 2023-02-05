package br.com.hfn.investbe.exception;

import java.util.List;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidatorException  extends RuntimeException{

	private static final long serialVersionUID = -4919772373527399998L;
	
	private List<FieldMessage> erros;
	
	public ValidatorException(String mensagem, List<FieldMessage> erros) {
		super(mensagem);
		this.erros = erros;
	}

}
