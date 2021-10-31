package br.com.hfn.investbe.exception.resource;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardError implements Serializable{

	private static final long serialVersionUID = 5705341169842040407L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;

}
