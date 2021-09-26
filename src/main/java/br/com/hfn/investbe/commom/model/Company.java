package br.com.hfn.investbe.commom.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Company Entity - Maps access to company data
 * @author hefreita
 *
 */
@Entity
@Table(name="COMPANY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String ein;
	
}
