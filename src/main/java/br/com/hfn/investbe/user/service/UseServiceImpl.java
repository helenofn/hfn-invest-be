package br.com.hfn.investbe.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import br.com.hfn.investbe.commom.model.Role;
import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.commom.repository.UserRepository;
import br.com.hfn.investbe.commom.security.dto.AuthenticationResponseDTO;
import br.com.hfn.investbe.common.exception.EmailAlreadyExistisException;
import br.com.hfn.investbe.common.exception.InvalidUserAuthenticationException;
import br.com.hfn.investbe.common.exception.UserNotFoundException;
import br.com.hfn.investbe.common.transformer.UserTransfomer;
import br.com.hfn.investbe.common.util.GenerateHashPasswordUtil;
import br.com.hfn.investbe.common.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class UseServiceImpl implements UserService{

	private final UserRepository userRepository;
		
	public AuthenticationResponseDTO authenticate(String username, String password) {
		
		if(!StringUtil.isEmpty(password) && !StringUtil.isEmpty(username)) {
			String hashPass = GenerateHashPasswordUtil.getHasFromPassword(password);
			System.out.println(hashPass);
			User user = userRepository.findByEmail(username).orElseThrow(
					()-> new InvalidUserAuthenticationException("Usuário não encontrado",true));
			if(!GenerateHashPasswordUtil.isPasswordMatch(password, user.getPassword())) {
				throw new InvalidUserAuthenticationException("Senha inválida",true);
			}
			List<GrantedAuthority> roles = getRoles(user);
			if(null==roles || roles.isEmpty()) {
				throw new InvalidUserAuthenticationException("Usuário não possui roles associadas",true);
			}
			
			return new AuthenticationResponseDTO(username,password, roles, UserTransfomer.getDtoFromModel(user));
			
		}else {
			log.error("Usuário ou senha não informados");
			throw new InvalidUserAuthenticationException("Usuário ou senha não informados", true);
		}
	}
	
	private List<GrantedAuthority> getRoles(User user){
		List<GrantedAuthority> lista = new ArrayList<>();
		for (Role role : user.getRoles()) {
			lista.add(new SimpleGrantedAuthority(role.getName()));
		}
		return lista;
	}
	
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
}
