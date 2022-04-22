package br.com.hfn.investbe.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.request.dto.BrokerRequestDTO;
import br.com.hfn.investbe.util.StringUtil;
import br.com.hfn.investbe.validation.annotations.BrokerInsert;

public class BrokerUpdateValidation implements ConstraintValidator<BrokerInsert, BrokerRequestDTO>{
	
	@Override
	public boolean isValid(BrokerRequestDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(StringUtil.isEmpty(objDto.getName())) {
			list.add(new FieldMessage("nome","O campo nome deve ser preenchido"));
		}
		
		if(StringUtil.isEmpty(objDto.getEin())) {
			list.add(new FieldMessage("ein","O campo ein deve ser preenchido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
