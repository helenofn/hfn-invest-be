package br.com.hfn.investbe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.exception.ObjectNotFoundException;
import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.UserStatus;
import br.com.hfn.investbe.response.dto.RoleResponseDTO;
import br.com.hfn.investbe.response.dto.StatusResponseDTO;
import br.com.hfn.investbe.response.dto.UserStatusResponseDTO;
import br.com.hfn.investbe.service.DominioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/dominio")
@RequiredArgsConstructor
public class DominioController extends CommonController{

	private final DominioService dominioService;
	private final ModelMapper modelMapper;
	
	@GetMapping(value = "/userStatusListAll")
	public ResponseEntity<List<UserStatusResponseDTO>> userStatusListAll(){
		List<UserStatus> list = dominioService.userStatusListAll().orElseThrow(() -> new ObjectNotFoundException("A lista de status de usuários está vazia.", true));
		List<UserStatusResponseDTO> listDto = list.stream().map(obj -> new UserStatusResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/roleListAll")
	public ResponseEntity<List<RoleResponseDTO>> roleListAll(){
		List<Role> list = dominioService.roleListAll().orElseThrow(() -> new ObjectNotFoundException("A lista de role de usuários está vazia.", true));
		List<RoleResponseDTO> listDto = list.stream().map(obj -> modelMapper.map(obj, RoleResponseDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/statusListAll")
	public ResponseEntity<List<StatusResponseDTO>> statusListAll(){
		return ResponseEntity.ok().body(dominioService.statusListAll());
	}

}
