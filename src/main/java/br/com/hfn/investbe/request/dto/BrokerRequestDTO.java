package br.com.hfn.investbe.request.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrokerRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 9047258315260991938L;
	
	private Integer seqId;
	private Integer internalId;
	private String name;
	private String ein;
}
