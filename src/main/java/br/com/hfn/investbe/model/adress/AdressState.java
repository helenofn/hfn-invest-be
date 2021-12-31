package br.com.hfn.investbe.model.adress;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AdressState entity - Maps access to AdressState data
 * @author hefreita
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADRESS_STATE")
public class AdressState implements Serializable{
	
	private static final long serialVersionUID = -1957993012806516725L;

	@Id
	@Column(name = "cseq_state", length = 18)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cseq_country")
	private AdressCountry country;
	
	@Column(name = "ds_sigla", length = 10)
	private String sigla;
	
	@Column(name = "ds_name", length = 70)
	private String name;
}
