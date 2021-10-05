package br.com.hfn.investbe.commom.profile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hfn.investbe.commom.repository.RoleRepository;
import br.com.hfn.investbe.commom.security.enums.RoleEnum;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Bean
	public boolean instantiateDatabase() {
		
		roleRepo.save(RoleEnum.COMMOM.getModel());
		roleRepo.save(RoleEnum.ADM.getModel());
		
		return true;
	}
	
}
