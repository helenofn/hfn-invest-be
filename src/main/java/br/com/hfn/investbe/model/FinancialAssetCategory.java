package br.com.hfn.investbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset category entity - Maps access to financial asset category data
 * @author hefreita
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET_CATEGORY")
public class FinancialAssetCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset_category", length = 4)
	private Integer id;
	@Column(name = "ds_name", length = 100)
	private String name;
	@Column(name = "ds_description", length = 500)
	private String description;
	
}
