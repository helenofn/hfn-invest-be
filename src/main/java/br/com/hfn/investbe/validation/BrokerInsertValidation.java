package br.com.hfn.investbe.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.request.dto.NewBrokerRequestDTO;
import br.com.hfn.investbe.service.BrokerService;
import br.com.hfn.investbe.util.StringUtil;
import br.com.hfn.investbe.validation.annotations.BrokerInsert;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BrokerInsertValidation implements ConstraintValidator<BrokerInsert, NewBrokerRequestDTO>{

	private final BrokerService brokerService;
	
	@Override
	public boolean isValid(NewBrokerRequestDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(StringUtil.isEmpty(objDto.getName())) {
			list.add(new FieldMessage("nome","O campo nome deve ser preenchido"));
		}
		
		if(StringUtil.isEmpty(objDto.getEin())) {
			list.add(new FieldMessage("ein","O campo ein deve ser preenchido"));
		}
		
		if(brokerService.findByEin(objDto.getEin()).isPresent()) {
			list.add(new FieldMessage("ein", "O ein informado já foi cadastrado em outro registros de corretora em nossa base de dados."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
