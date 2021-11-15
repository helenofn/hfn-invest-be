package br.com.hfn.investbe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.dominio.service.DominioService;
import br.com.hfn.investbe.dto.RoleDTO;
import br.com.hfn.investbe.dto.UserStatusDTO;
import br.com.hfn.investbe.exception.ObjectNotFoundException;
import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.UserStatus;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/dominio")
@RequiredArgsConstructor
public class DominioController {

	private final DominioService dominioService;
	
	@GetMapping(value = "/userStatusListAll")
	public ResponseEntity<List<UserStatusDTO>> userStatusListAll(){
		List<UserStatus> list = dominioService.userStatusListAll().orElseThrow(() -> new ObjectNotFoundException("A lista de status de usuários está vazia.", true));
		List<UserStatusDTO> listDto = list.stream().map(obj -> new UserStatusDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/roleListAll")
	public ResponseEntity<List<RoleDTO>> roleListAll(){
		List<Role> list = dominioService.roleListAll().orElseThrow(() -> new ObjectNotFoundException("A lista de role de usuários está vazia.", true));
		List<RoleDTO> listDto = list.stream().map(obj -> new RoleDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
