package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.request.dto.NewFinancialAssetCategoryRequestDTO;
import br.com.hfn.investbe.validator.annotations.NewFinancialAssetCategory;

public class NewFinancialAssetCategoryValidator implements ConstraintValidator<NewFinancialAssetCategory, NewFinancialAssetCategoryRequestDTO>{

	@Override
	public boolean isValid(NewFinancialAssetCategoryRequestDTO value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		/*if(StringUtil.isEmpty(objDto.getName())) {
			list.add(new FieldMessage("tipo","O campo nome deve ser preenchido"));
		}*/
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
