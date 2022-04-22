package br.com.hfn.investbe.response.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponseDTO implements Serializable{

	private static final long serialVersionUID = 8284403962236764768L;
	
	private Integer code;
	private String name;

}
