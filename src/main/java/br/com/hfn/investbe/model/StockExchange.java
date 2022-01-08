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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StockExchange entity - Maps access to StockExchange data
 * @author Heleno
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="STOCK_EXCHANGE")
public class StockExchange implements Serializable{

	private static final long serialVersionUID = 6191979857644758825L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_stock_exchange", length = 18)
	private Integer seqId;
	
	@Column(name = "cd_internal", length = 18, unique = true)
	private Long internalId;
	
	@Column(name = "ds_name", length = 150)
	private String name;
	@Column(name = "ds_ein", length = 20)
	private String ein;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_adress")
	private Adress mainAdress;
}
