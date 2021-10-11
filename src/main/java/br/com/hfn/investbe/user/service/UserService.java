package br.com.hfn.investbe.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.commom.repository.UserRepository;
import br.com.hfn.investbe.common.exception.EmailAlreadyExistisException;
import br.com.hfn.investbe.common.exception.UserNotFoundException;
import br.com.hfn.investbe.common.util.GenerateHashPasswordUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService{

	private final UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("Usuário não encontrado em nossa base de dados.",true));
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}
		
	public User save(User user) {
		if(null!=findByEmail(user.getEmail())) {
			throw new EmailAlreadyExistisException("O Usuário já existe em nossa base de dados.",true);
		}
		user.setPassword(GenerateHashPasswordUtil.getHasFromPassword(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User update(User user) {
		User newObj = findById(user.getId());
		newObj.setName(user.getName());
		newObj.setEmail(user.getEmail());
		newObj.setStatus(user.getStatus());
		return userRepository.save(newObj);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepository.findAll(pageRequest);
	}
}
