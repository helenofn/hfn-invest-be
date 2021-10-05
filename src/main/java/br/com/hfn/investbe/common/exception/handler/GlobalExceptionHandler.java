package br.com.hfn.investbe.common.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hfn.investbe.common.dto.ResponseDTO;
import br.com.hfn.investbe.common.exception.EmailAlreadyExistisException;
import br.com.hfn.investbe.common.exception.HfnInvestException;
import br.com.hfn.investbe.common.exception.InvalidUserAuthenticationException;
import br.com.hfn.investbe.common.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = HfnInvestException.class)
	public ResponseEntity<Object> hfnInvestException(HttpServletRequest req, HfnInvestException e){
		return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).build();
	}
	
	@ExceptionHandler(value = EmailAlreadyExistisException.class)
	public ResponseEntity<Object> emailAlreadyExistisException(HttpServletRequest req, EmailAlreadyExistisException e){
		return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(new ResponseDTO(400,"Bad Request","E-mail já existente", e.getMessage(),e.isShowMessage()));
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(HttpServletRequest req, UserNotFoundException e){
		return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(new ResponseDTO(400,"Bad Request","Usuário não encontrado", e.getMessage(),e.isShowMessage()));
	}
	
	@ExceptionHandler(value = InvalidUserAuthenticationException.class)
	public ResponseEntity<Object> invalidUserAuthenticationException(HttpServletRequest req, InvalidUserAuthenticationException e){
		return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(new ResponseDTO(400,"Bad Request","A autenticação falhou", e.getMessage(),e.isShowMessage()));
	}
	
}
