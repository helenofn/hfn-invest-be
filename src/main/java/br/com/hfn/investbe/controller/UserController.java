package br.com.hfn.investbe.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.model.user.User;
import br.com.hfn.investbe.request.dto.FilterUserRequestDTO;
import br.com.hfn.investbe.request.dto.UserRequestDTO;
import br.com.hfn.investbe.response.dto.UserResponseDTO;
import br.com.hfn.investbe.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final ModelMapper modelMapper;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody UserRequestDTO userDto, @PathVariable Long id){
		User user = modelMapper.map(userDto, User.class);
		user.setId(id);
		userService.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
		UserResponseDTO userDto = modelMapper.map(userService.findById(id), UserResponseDTO.class);//UserTransfomer.getDtoFromModel(userService.findById(id));
        return ResponseEntity.ok().body(userDto);
    }
	
	@PostMapping(value = "/page")
	public ResponseEntity<Page<UserResponseDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "15") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestBody FilterUserRequestDTO filtro){
		
		Page<User> list = userService.findPage(page, linesPerPage, direction, orderBy, filtro);
		Page<UserResponseDTO> listDto = list.map(obj -> modelMapper.map(obj, UserResponseDTO.class));
        return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>>findAll(){
		List<User> lista = userService.findAll();
		List<UserResponseDTO> listDTO = lista.stream().map(obj ->  modelMapper.map(obj, UserResponseDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);	
	}
}
