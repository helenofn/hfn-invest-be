package br.com.hfn.investbe.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.hfn.investbe.exception.resource.FieldMessage;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.request.dto.NewUserRequestDTO;
import br.com.hfn.investbe.service.UserService;
import br.com.hfn.investbe.util.StringUtil;
import br.com.hfn.investbe.validator.annotations.UserInsert;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserInsertValidator implements ConstraintValidator<UserInsert, NewUserRequestDTO>{

	private final UserService userService;
	
	@Override
	public boolean isValid(NewUserRequestDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(StringUtil.isEmpty(objDto.getName())) {
			list.add(new FieldMessage("tipo","O campo nome deve ser preenchido"));
		}
		
		if(StringUtil.isEmpty(objDto.getEmail())) {
			list.add(new FieldMessage("tipo","O campo e-mail deve ser preenchido"));
		}
		
		User userAux = userService.findByEmail(objDto.getEmail());
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
