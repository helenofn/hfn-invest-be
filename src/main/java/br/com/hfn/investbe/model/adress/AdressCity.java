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
 * AdressCity entity - Maps access to AdressCity data
 * @author hefreita
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADRESS_CITY")
public class AdressCity implements Serializable{

	private static final long serialVersionUID = -752742295565061841L;

	@Id
	@Column(name = "cseq_city", length = 18)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cseq_state")
	private AdressState state;
	
	@Column(name = "ds_name", length = 70)
	private String name;
}
