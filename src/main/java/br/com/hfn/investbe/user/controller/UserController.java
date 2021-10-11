package br.com.hfn.investbe.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.common.dto.UserDTO;
import br.com.hfn.investbe.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody UserDTO userDto, @PathVariable Long id){
		User user = new User(userDto);//UserTransfomer.getModelFromDto(userDto);
		user.setId(id);
		userService.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO userDto = new UserDTO(userService.findById(id));//UserTransfomer.getDtoFromModel(userService.findById(id));
        return ResponseEntity.ok().body(userDto);
    }
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<UserDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "15") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
		
		Page<User> list = userService.findPage(page, linesPerPage, direction, orderBy);
		Page<UserDTO> listDto = list.map(obj -> new UserDTO(obj));
        return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		List<User> lista = userService.findAll();
		List<UserDTO> listDTO = lista.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);	
	}
}
