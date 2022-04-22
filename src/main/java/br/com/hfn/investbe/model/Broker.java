package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.hfn.investbe.enums.StatusEnum;
import br.com.hfn.investbe.request.dto.BrokerRequestDTO;
import br.com.hfn.investbe.request.dto.NewBrokerRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Broker entity - Maps access to Broker data - 
 * Entity responsible for carrying out brokerage services for financial assets
 * @author hefreita
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BROKER")
public class Broker implements Serializable{

	private static final long serialVersionUID = 6507010296243050159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_broker", length = 9)
	private Integer seqId;
	
	@Column(name = "internal_id", length = 9)
	private Integer internalId;
	
	@Column(name = "cd_status", length = 1)
	private StatusEnum status;
	
	@Column(name = "ds_name", length = 150)
	private String name;
	
	@Column(name = "ds_ein", length = 20)
	private String ein;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_adress")
	private Adress mainAdress;
	
	public Broker(NewBrokerRequestDTO newDto) {
		this.internalId = newDto.getInternalId();
		this.name = newDto.getName();
		this.ein = newDto.getEin();
	}
	
	public Broker(BrokerRequestDTO newDto) {
		this.seqId = newDto.getSeqId();
		this.internalId = newDto.getInternalId();
		this.name = newDto.getName();
		this.ein = newDto.getEin();
	}
}
