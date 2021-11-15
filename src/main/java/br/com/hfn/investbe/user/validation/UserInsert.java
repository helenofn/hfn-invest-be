package br.com.hfn.investbe.user.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserInsertValidation.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserInsert {

	String message() default "Ocorreram as seguintes críticas: ";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}