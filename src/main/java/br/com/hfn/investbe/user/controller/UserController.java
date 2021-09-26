package br.com.hfn.investbe.user.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.common.dto.UserDTO;
import br.com.hfn.investbe.common.transformer.UserTransfomer;
import br.com.hfn.investbe.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO userDto = UserTransfomer.getDtoFromModel(userService.findById(id));
        return ResponseEntity.ok().body(userDto);
    }
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
		User user = UserTransfomer.getModelFromDto(userDto);
		user = userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
