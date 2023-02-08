package br.com.hfn.investbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset category entity - Maps access to financial asset category data
 * @author hefreita
 *
 */

@Builder
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
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=4, max=100, message="O tamanho do nome deve ser entre 4 e 100 caracteres")
	@Column(name = "ds_name", length = 100)
	private String name;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=4, max=100, message="O tamanho da descrição deve ser entre 4 e 500 caracteres")
	@Column(name = "ds_description", length = 500)
	private String description;
}
