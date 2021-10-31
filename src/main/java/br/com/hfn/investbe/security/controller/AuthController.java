package br.com.hfn.investbe.security.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hfn.investbe.dto.UserDTO;
import br.com.hfn.investbe.dto.UserNewDTO;
import br.com.hfn.investbe.enums.UserStatusEnum;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.security.dto.AuthenticationRequestDTO;
import br.com.hfn.investbe.security.dto.AuthenticationResponseDTO;
import br.com.hfn.investbe.security.enums.RoleEnum;
import br.com.hfn.investbe.security.provider.JwtTokenProvider;
import br.com.hfn.investbe.security.service.AuthenticationService;
import br.com.hfn.investbe.service.UserService;
import br.com.hfn.investbe.transformer.UserTransfomer;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;
	private final AuthenticationService authenticationService;
	private final JwtTokenProvider jwtTokenProvider;
	
	@PostMapping(path = "/signUp")
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserNewDTO userDto){
		User user = UserTransfomer.getModelFromNewDto(userDto);
		user.getRoles().addAll(Arrays.asList(RoleEnum.COMMOM.getModel()));
		user.setStatus(UserStatusEnum.ATIVO.getModel());
		user = userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(UserTransfomer.getDtoFromModel(user));
	}
	
	@PostMapping(path = "/logIn")
	public ResponseEntity<Map<Object, Object>> logIn(@Valid @RequestBody AuthenticationRequestDTO authenticationRequest){
		
		AuthenticationResponseDTO auth = authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		String token = jwtTokenProvider.createToken(authenticationRequest.getUsername(), auth.getAuthorities());
		
		Map<Object, Object> model = new HashMap<>();
		model.put("user", auth.getUser());
		model.put("roles", auth.getAuthorities());
		model.put("token", token);
		return ResponseEntity.ok(model);
	}
	
	@GetMapping(value = "{token}")
	public ResponseEntity<Boolean> validToken(@PathVariable("token") String token){
		return ResponseEntity.ok((null!=token && jwtTokenProvider.validateToken(token)));
	}
	
}
