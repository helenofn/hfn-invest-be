package br.com.hfn.investbe.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hfn.investbe.config.dto.UserAuthDTO;
import br.com.hfn.investbe.config.provider.JwtTokenProvider;
import br.com.hfn.investbe.enums.RoleEnum;
import br.com.hfn.investbe.enums.UserStatusEnum;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.request.dto.AuthenticationRequestDTO;
import br.com.hfn.investbe.request.dto.UserInsertRequestDTO;
import br.com.hfn.investbe.response.dto.UserResponseDTO;
import br.com.hfn.investbe.service.AuthenticationService;
import br.com.hfn.investbe.service.UserService;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController extends CommonController{

	private final UserService userService;
	private final AuthenticationService authenticationService;
	private final JwtTokenProvider jwtTokenProvider;
	private final ModelMapper modelMapper;
	
	@PostMapping(path = "/signUp")
	public ResponseEntity<UserResponseDTO> insert(@Valid @RequestBody UserInsertRequestDTO userDto){
		User user = modelMapper.map(userDto, User.class);
		user.getRoles().addAll(Arrays.asList(RoleEnum.COMMOM.getModel()));
		user.setStatus(UserStatusEnum.ATIVO.getModel());
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(modelMapper.map(user, UserResponseDTO.class));
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<Map<Object, Object>> login(@Valid @RequestBody AuthenticationRequestDTO authenticationRequest){
		
		UserAuthDTO auth = authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		String token = jwtTokenProvider.createToken(authenticationRequest.getUsername(), auth.getAuthorities());
		
		Map<Object, Object> model = new HashMap<>();
		model.put("user", modelMapper.map(auth.getUser(), UserResponseDTO.class));
		model.put("roles", auth.getAuthorities());
		model.put("token", token);
		return ResponseEntity.ok(model);
	}
	
	@GetMapping(value = "{token}")
	public ResponseEntity<Boolean> validToken(@PathVariable("token") String token){
		return ResponseEntity.ok((null!=token && jwtTokenProvider.validateToken(token)));
	}
	
}
