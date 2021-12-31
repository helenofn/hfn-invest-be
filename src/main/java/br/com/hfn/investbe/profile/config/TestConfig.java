package br.com.hfn.investbe.profile.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hfn.investbe.enums.FinancialAssetCategoryEnum;
import br.com.hfn.investbe.enums.UserStatusEnum;
import br.com.hfn.investbe.model.adress.AdressCity;
import br.com.hfn.investbe.model.adress.AdressCountry;
import br.com.hfn.investbe.model.adress.AdressState;
import br.com.hfn.investbe.model.user.Role;
import br.com.hfn.investbe.model.user.User;
import br.com.hfn.investbe.repository.AdressCityRepository;
import br.com.hfn.investbe.repository.AdressCountryRepository;
import br.com.hfn.investbe.repository.AdressStateRepository;
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
	@Autowired
	private AdressCityRepository adressCityRepository;
	@Autowired
	private AdressCountryRepository adressCountryRepository;
	@Autowired
	private AdressStateRepository adressStateRepository;
	
	@Bean
	public boolean instantiateDatabase() {
		
		//ROLES
		roleRepo.save(RoleEnum.COMMOM.getModel());
		roleRepo.save(RoleEnum.ADM.getModel());
		//USER STATUS
		userStatusRepo.save(UserStatusEnum.ATIVO.getModel());
		userStatusRepo.save(UserStatusEnum.INATIVO.getModel());
		//FINANCIAL ASSET CATEGORIES
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.ACOES.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.FIIS.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.STOCKS.getModel());
		financialAssetCategoryRepository.save(FinancialAssetCategoryEnum.REITS.getModel());
		//COUNTRY
		AdressCountry brazil = new AdressCountry(1L,"Brazil");
		adressCountryRepository.save(brazil);
		//STATES
		AdressState rioDeJaneiro = new AdressState(1L,brazil,"RJ","Rio de Janeiro");
		AdressState saoPaulo = new AdressState(1L,brazil,"SP","São Paulo");
		adressStateRepository.saveAll(Arrays.asList(rioDeJaneiro,saoPaulo));
		//CITIES
		AdressCity cityRioDeJaneiro = new AdressCity(1L,rioDeJaneiro,"Rio de Janeiro");
		AdressCity citySaoPaulo = new AdressCity(1L,saoPaulo,"São Paulo");
		adressCityRepository.saveAll(Arrays.asList(cityRioDeJaneiro,citySaoPaulo));
		
		
		//TEST USER
		List<Role> roles1 = new ArrayList<>();
		roles1.add(RoleEnum.COMMOM.getModel());
		roles1.add(RoleEnum.ADM.getModel());
		List<Role> roles2 = new ArrayList<>();
		roles1.add(RoleEnum.COMMOM.getModel());
		User userAdm = new User();
		userAdm.setName("Heleno Freitas Neto Adm");
		userAdm.setEmail("heleno.freitas@gmail.com");
		userAdm.setPassword("12345678");
		userAdm.setRoles(roles1);
		userAdm.setStatus(UserStatusEnum.ATIVO.getModel());
		User userCommon = new User();
		userCommon.setName("Heleno Freitas Neto Common");
		userCommon.setEmail("helenoCommon.freitas@gmail.com");
		userCommon.setPassword("12345678");
		userCommon.setRoles(roles2);
		userCommon.setStatus(UserStatusEnum.ATIVO.getModel());
		userService.save(userAdm);
		userService.save(userCommon);
		
		return true;
	}
	
}
