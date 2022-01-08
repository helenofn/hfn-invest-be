package br.com.hfn.investbe.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import br.com.hfn.investbe.exception.HfnInvestException;
import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.repository.UserRepository;
import br.com.hfn.investbe.response.dto.AuthenticationResponseDTO;
import br.com.hfn.investbe.response.dto.UserResponseDTO;
import br.com.hfn.investbe.util.GenerateHashPasswordUtil;
import br.com.hfn.investbe.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationService{

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public AuthenticationResponseDTO authenticate(String username, String password) {
		
		if(!StringUtil.isEmpty(password) && !StringUtil.isEmpty(username)) {
			String hashPass = GenerateHashPasswordUtil.getHasFromPassword(password);
			System.out.println(hashPass);
			User user = userRepository.findByEmail(username).orElseThrow(
					()-> new HfnInvestException("Usuário não encontrado",true));
			if(!GenerateHashPasswordUtil.isPasswordMatch(password, user.getPassword())) {
				throw new HfnInvestException("Senha inválida",true);
			}
			List<GrantedAuthority> roles = getRoles(user);
			if(null==roles || roles.isEmpty()) {
				throw new HfnInvestException("Usuário não possui roles associadas",true);
			}
			return new AuthenticationResponseDTO(username,password, roles, modelMapper.map(user, UserResponseDTO.class));
			
		}else {
			log.error("Usuário ou senha não informados");
			throw new HfnInvestException("Usuário ou senha não informados", true);
		}
	}
	
	private List<GrantedAuthority> getRoles(User user){
		List<GrantedAuthority> lista = new ArrayList<>();
		for (Role role : user.getRoles()) {
			lista.add(new SimpleGrantedAuthority(role.getName()));
		}
		return lista;
	}
}
