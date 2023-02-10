package br.com.hfn.investbe.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.hfn.investbe.exception.ObjectNotFoundException;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.model.specification.UserSpecification;
import br.com.hfn.investbe.repository.UserRepository;
import br.com.hfn.investbe.request.dto.UserFilterRequestDTO;
import br.com.hfn.investbe.util.GenerateHashPasswordUtil;
import br.com.hfn.investbe.validator.annotations.UserInsert;
import br.com.hfn.investbe.validator.annotations.UserUpdate;
import lombok.RequiredArgsConstructor;

@Validated
@Service
@RequiredArgsConstructor
public class UserService extends UserSpecification{

	private final UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Usuário não encontrado em nossa base de dados.",true));
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}
		
	public User insert(@Valid @UserInsert User user) {
		user.setPassword(GenerateHashPasswordUtil.getHasFromPassword(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User update(@UserUpdate User user) {
		User newObj = findById(user.getId());
		newObj.setName(user.getName());
		newObj.setEmail(user.getEmail());
		newObj.setStatus(user.getStatus());
		newObj.setRoles(user.getRoles());
		return userRepository.save(newObj);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String direction, String orderBy, UserFilterRequestDTO filtro){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Specification<User> specification = 
				Specification
					.where(emailLike(filtro.getEmail()))
					.and(nameLike(filtro.getName()))
					.and(statusCodeEquals(filtro.getStatusCode()));
		
		return userRepository.findAll(specification,pageRequest);
	}

}
