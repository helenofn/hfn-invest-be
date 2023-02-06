package br.com.hfn.investbe.response.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponseDTO {

	private Integer status;
	private String msg;
	private Long timeStamp;
	private List<FieldMessage> errors = new ArrayList<>();
	
	public void addError(String fieldName, String msgErro) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(new FieldMessage(fieldName, msgErro));
	}
}
