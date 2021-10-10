package br.com.hfn.investbe.commom.profile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hfn.investbe.commom.repository.RoleRepository;
import br.com.hfn.investbe.commom.repository.UserStatusRepository;
import br.com.hfn.investbe.commom.security.enums.RoleEnum;
import br.com.hfn.investbe.common.enums.UserStatusEnum;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserStatusRepository userStatusRepo;
	
	@Bean
	public boolean instantiateDatabase() {
		
		roleRepo.save(RoleEnum.COMMOM.getModel());
		roleRepo.save(RoleEnum.ADM.getModel());
		userStatusRepo.save(UserStatusEnum.ATIVO.getModel());
		userStatusRepo.save(UserStatusEnum.INATIVO.getModel());
		return true;
	}
	
}
