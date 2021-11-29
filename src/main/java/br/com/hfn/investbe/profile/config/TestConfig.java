package br.com.hfn.investbe.profile.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hfn.investbe.enums.FinancialAssetCategoryEnum;
import br.com.hfn.investbe.enums.UserStatusEnum;
import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.repository.FinancialAssetCategoryRepository;
import br.com.hfn.investbe.repository.RoleRepository;
import br.com.hfn.investbe.repository.UserStatusRepository;
import br.com.hfn.investbe.security.enums.RoleEnum;
import br.com.hfn.investbe.service.UserService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserStatusRepository userStatusRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private FinancialAssetCategoryRepository financialAssetCategoryRepository;
	
	@Bean
	public boolean instantiateDatabase() {
		
		roleRepo.save(RoleEnum.COMMOM.getModel());
		roleRepo.save(RoleEnum.ADM.getModel());
		userStatusRepo.save(UserStatusEnum.ATIVO.getModel());
		userStatusRepo.save(UserStatusEnum.INATIVO.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.ACOES.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.FIIS.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.STOCKS.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.REITS.getModel());
		
		List<Role> roles = new ArrayList<>();
		roles.add(RoleEnum.COMMOM.getModel());
		roles.add(RoleEnum.ADM.getModel());
		
		User user = new User();
		user.setName("Heleno Freitas Neto");
		user.setEmail("heleno.freitas@gmail.com");
		user.setPassword("12345678");
		user.setRoles(roles);
		user.setStatus(UserStatusEnum.ATIVO.getModel());
		
		userService.save(user);
		
		return true;
	}
	
}
