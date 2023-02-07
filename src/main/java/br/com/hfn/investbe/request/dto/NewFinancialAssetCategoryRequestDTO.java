package br.com.hfn.investbe.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewFinancialAssetCategoryRequestDTO {

	private String name;
	private String description;
}
