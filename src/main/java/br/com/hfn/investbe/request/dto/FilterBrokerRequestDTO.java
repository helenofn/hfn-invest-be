package br.com.hfn.investbe.request.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterBrokerRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 2429393291529512858L;
	
	private Integer seqId;
	private Integer internalId;
	private String name;
	private String ein;
	
}
