package br.com.hfn.investbe.response.dto;

import java.io.Serializable;

import br.com.hfn.investbe.model.Broker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerResponseDTO implements Serializable{

	private static final long serialVersionUID = 5520512153295960843L;
	
	private Integer seqId;
	private Integer internalId;
	private Integer statusCode;
	private String name;
	private String ein;
	
	public BrokerResponseDTO(Broker model) {
		this.seqId = model.getSeqId();
		this.internalId = model.getInternalId();
		this.name = model.getName();
		this.ein = model.getEin();
		this.statusCode = model.getStatus().getCode();
	}

}
