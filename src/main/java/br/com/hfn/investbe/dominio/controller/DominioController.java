package br.com.hfn.investbe.dominio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.commom.model.UserStatus;
import br.com.hfn.investbe.common.dto.UserStatusDTO;
import br.com.hfn.investbe.dominio.service.DominioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/dominio")
@RequiredArgsConstructor
public class DominioController {

	private final DominioService dominioService;
	
	@GetMapping(value = "/userStatusListAll")
	public ResponseEntity<List<UserStatusDTO>> userStatusListAll(){
		List<UserStatus> list = dominioService.userStatusListAll();
		List<UserStatusDTO> listDto = list.stream().map(obj -> new UserStatusDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
