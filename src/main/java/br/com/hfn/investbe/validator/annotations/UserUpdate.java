package br.com.hfn.investbe.validator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.hfn.investbe.validator.UserUpdateValidator;

@Constraint(validatedBy = UserUpdateValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserUpdate {

	String message() default "Ocorreram as seguintes críticas: ";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
