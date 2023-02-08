package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.model.FinancialAssetCategory;
import br.com.hfn.investbe.request.dto.NewFinancialAssetCategoryRequestDTO;
import br.com.hfn.investbe.service.FinancialAssetCategoryService;
import br.com.hfn.investbe.validator.annotations.NewFinancialAssetCategory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NewFinancialAssetCategoryValidator implements ConstraintValidator<NewFinancialAssetCategory, NewFinancialAssetCategoryRequestDTO>{

	private final FinancialAssetCategoryService financialAssetCategoryService;
	
	@Override
	public boolean isValid(NewFinancialAssetCategoryRequestDTO value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		List<FinancialAssetCategory> listaCategoria = financialAssetCategoryService.findByName(value.getName()).orElse(null);
		if(null != listaCategoria && !listaCategoria.isEmpty()) {
			list.add(new FieldMessage("name","Já existe uma categoria de ativo financeiro com este nome."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
