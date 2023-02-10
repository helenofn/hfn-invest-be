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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.hfn.investbe.enums.StatusEnum;
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
	
	@NotNull(message="O campo id interno tem preenchimento Obrigatório")
	@Column(name = "internal_id", length = 9)
	private Integer internalId;
	
	@Column(name = "cd_status", length = 1)
	private StatusEnum status;
	
	@NotEmpty(message="O campo nome tem preenchimento Obrigatório")
	@Length(min=5, max=150, message="O tamanho do nome deve ser entre 5 e 150 caracteres")
	@Column(name = "ds_name", length = 150)
	private String name;
	
	@NotEmpty(message="O campo cnpj tem preenchimento obrigatório")
	@Length(min=5, max=20, message="O tamanho código da pessoa jurídica dever entre 5 e 20 caracteres")
	@Column(name = "ds_ein", length = 20)
	private String ein;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_adress")
	private Adress mainAdress;
}
