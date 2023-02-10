package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.service.BrokerService;
import br.com.hfn.investbe.validator.annotations.BrokerInsert;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BrokerInsertValidator implements ConstraintValidator<BrokerInsert, Broker>{

	private final BrokerService brokerService;
	
	@Override
	public boolean isValid(Broker obj, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(brokerService.findByEin(obj.getEin()).isPresent()) {
			list.add(new FieldMessage("ein", "O cnpj informado já foi cadastrado em outro registros de corretora em nossa base de dados."));
		}
		
		if(brokerService.findByInternalId(obj.getInternalId()).isPresent()) {
			list.add(new FieldMessage("internalId", "Já existe um outro registro de corretora usando o id interno informado."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
