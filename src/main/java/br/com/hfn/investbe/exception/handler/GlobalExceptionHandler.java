package br.com.hfn.investbe.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hfn.investbe.exception.DataIntegrityException;
import br.com.hfn.investbe.exception.HfnInvestException;
import br.com.hfn.investbe.exception.ObjectNotFoundException;
import br.com.hfn.investbe.exception.ValidatorException;
import br.com.hfn.investbe.exception.resource.StandardError;
import br.com.hfn.investbe.response.dto.ExceptionResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = HfnInvestException.class)
	public ResponseEntity<Object> hfnInvestException(HttpServletRequest req, HfnInvestException e){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(value = ObjectNotFoundException.class)
	public ResponseEntity<Object> objectNotFoundException(HttpServletRequest req, ObjectNotFoundException e){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(value = DataIntegrityException.class)
	public ResponseEntity<Object> dataIntegrityException(HttpServletRequest req, DataIntegrityException e){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<Object> accessDeniedException(HttpServletRequest req, AccessDeniedException e){
		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponseDTO err = new ExceptionResponseDTO(HttpStatus.NOT_ACCEPTABLE.value(), "Ocorreram as seguintes criticas:", System.currentTimeMillis(), null);
		for (FieldError e : ex.getFieldErrors()){
			err.addError(e.getField(), e.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		ExceptionResponseDTO err = new ExceptionResponseDTO(HttpStatus.NOT_ACCEPTABLE.value(), "Ocorreram as seguintes criticas:", System.currentTimeMillis(), null);
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	    	String nomeCampo = violation.getPropertyPath()!=null? violation.getPropertyPath().toString() : "";
	    	err.addError(nomeCampo, violation.getMessage());
	    }
	    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
	}
	
	@ExceptionHandler({ ValidatorException.class })
	public ResponseEntity<Object> handleValidatorException(ValidatorException ex) {
		ExceptionResponseDTO err = new ExceptionResponseDTO(HttpStatus.NOT_ACCEPTABLE.value(), "Ocorreram as seguintes criticas:", System.currentTimeMillis(), null);
	    err.setErrors(ex.getErros());
	    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
	}
	
}
