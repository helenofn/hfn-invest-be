package br.com.hfn.investbe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.hfn.investbe.dto.UserDTO;
import br.com.hfn.investbe.exception.ObjectNotFoundException;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.repository.UserRepository;
import br.com.hfn.investbe.repository.specification.UserSpecification;
import br.com.hfn.investbe.util.GenerateHashPasswordUtil;
import br.com.hfn.investbe.util.StringUtil;
import lombok.RequiredArgsConstructor;

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
		
	public User save(User user) {
		/*if(null!=findByEmail(user.getEmail())) {
			throw new EmailAlreadyExistisException("O Usuário já existe em nossa base de dados.",true);
		}*/
		user.setPassword(GenerateHashPasswordUtil.getHasFromPassword(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User update(User user) {
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
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String direction, String orderBy, UserDTO filtro){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Specification<User> specification = 
				Specification
					.where(StringUtil.isEmpty(filtro.getEmail()) ? null : emailLike(filtro.getEmail()))
					.and(StringUtil.isEmpty(filtro.getName()) ? null : nameLike(filtro.getName()))
					.and(null == filtro.getStatus() || null == filtro.getStatus().getCode() ? null : statusCodeEquals(filtro.getStatus().getCode()));
		
		return userRepository.findAll(specification,pageRequest);
	}

}
