package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.service.BrokerService;
import br.com.hfn.investbe.validator.annotations.BrokerUpdate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BrokerUpdateValidator implements ConstraintValidator<BrokerUpdate, Broker>{
	
	private final BrokerService brokerService;
	
	@Override
	public boolean isValid(Broker obj, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(null == brokerService.findBySeqId(obj.getSeqId()).orElse(null)) {
			list.add(new FieldMessage("ein", "O id da corretora informado não existe."));
		}
		
		Broker brokerAux = brokerService.findByEin(obj.getEin()).orElse(null);
		if(null!=brokerAux && !brokerAux.getSeqId().equals(obj.getSeqId())) {
			list.add(new FieldMessage("ein", "O cnpj informado já foi cadastrado em outro registros de corretora em nossa base de dados."));
		}
		
		brokerAux = brokerService.findByInternalId(obj.getInternalId()).orElse(null);
		if(null!=brokerAux && !brokerAux.getSeqId().equals(obj.getSeqId())) {
			list.add(new FieldMessage("internalId", "Já existe um outro registro de corretora usando o id interno informado."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
