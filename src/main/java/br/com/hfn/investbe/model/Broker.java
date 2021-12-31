package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.hfn.investbe.model.adress.Adress;
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
	@Column(name = "cseq_broker", length = 22)
	private Integer id;
	
	@Column(name = "ds_name", length = 150)
	private String name;
	
	@Column(name = "ds_ein", length = 20)
	private String ein;
	
	@ManyToOne
	@JoinColumn(name = "cseq_adress")
	private Adress mainAdress;
}
