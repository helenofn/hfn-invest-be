package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.service.UserService;
import br.com.hfn.investbe.validator.annotations.UserInsert;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserInsertValidator implements ConstraintValidator<UserInsert, User>{

	private final UserService userService;
	
	@Override
	public boolean isValid(User obj, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		User userAux = userService.findByEmail(obj.getEmail());
		if (userAux != null) {
			list.add(new FieldMessage("email", "E-mail já existente em nossa base de dados."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

	
}
