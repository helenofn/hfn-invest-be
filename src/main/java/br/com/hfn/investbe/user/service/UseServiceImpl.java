package br.com.hfn.investbe.user.service;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.commom.repository.UserRepository;
import br.com.hfn.investbe.common.exception.EmailAlreadyExistisException;
import br.com.hfn.investbe.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UseServiceImpl implements UserService{

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
		return userRepository.save(user);
	}
	
	
	
	
}
