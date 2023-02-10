package br.com.hfn.investbe.request.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilterRequestDTO implements Serializable{

	private static final long serialVersionUID = -1076970482858410333L;
	
	private String name;
	private String email;
	private Integer statusCode;
}
