package br.com.hfn.investbe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset category entity - Maps access to financial asset category data
 * @author hefreita
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialAssetCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	
}
