package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.service.UserService;
import br.com.hfn.investbe.validator.annotations.UserUpdate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUpdateValidator implements ConstraintValidator<UserUpdate, User>{

	private final UserService userService;
	
	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		User userAux = userService.findByEmail(value.getEmail());
		if (userAux != null && !userAux.getId().equals(value.getId())) {
			list.add(new FieldMessage("email", "E-mail já existente em nossa base de dados."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
