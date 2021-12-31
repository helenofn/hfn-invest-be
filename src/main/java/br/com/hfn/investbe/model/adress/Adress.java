package br.com.hfn.investbe.model.adress;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * Adress entity - Maps access to Adress data
 * @author hefreita
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADRESS")
public class Adress implements Serializable{
	
	private static final long serialVersionUID = 8370050846081162696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_adress", length = 18)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cseq_city")
	private AdressCity city;
	
	@Column(name = "ds_adress", length = 150)
	private String dsAdress;
	
	@Column(name = "ds_complement", length = 150)
	private String adressComplement;
	
	@Column(name = "cd_zip_code", length = 22)
	private String zipCode;
}
