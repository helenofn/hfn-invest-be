package br.com.hfn.investbe.exception.resource;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldMessage implements Serializable{

	private static final long serialVersionUID = -4921183386330241054L;
	
	private String fieldName;
	private String message;
	
	

}
