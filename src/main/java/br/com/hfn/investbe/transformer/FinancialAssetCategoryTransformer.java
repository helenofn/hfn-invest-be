package br.com.hfn.investbe.transformer;

import br.com.hfn.investbe.dto.FinancialAssetCategoryDTO;
import br.com.hfn.investbe.model.FinancialAssetCategory;

public class FinancialAssetCategoryTransformer {

	public static FinancialAssetCategory getModelFromDto(FinancialAssetCategoryDTO dto) {
		return FinancialAssetCategory.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.build();
	}
	
	public static FinancialAssetCategoryDTO getDtoFromModel(FinancialAssetCategory model) {
		return FinancialAssetCategoryDTO.builder()
				.id(model.getId())
				.name(model.getName())
				.description(model.getDescription())
				.build();
	}
}
