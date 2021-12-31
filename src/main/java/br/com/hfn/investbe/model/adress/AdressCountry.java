package br.com.hfn.investbe.model.adress;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AdressCountry entity - Maps access to AdressCountry data
 * @author hefreita
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADRESS_COUNTRY")
public class AdressCountry implements Serializable{

	private static final long serialVersionUID = -1205091508653613625L;
	
	@Id
	@Column(name = "cseq_country", length = 18)
	private Long id;
	
	@Column(name = "ds_name", length = 70)
	private String name;
}
