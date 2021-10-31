package br.com.hfn.investbe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.dominio.service.DominioService;
import br.com.hfn.investbe.dto.UserStatusDTO;
import br.com.hfn.investbe.model.UserStatus;
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
