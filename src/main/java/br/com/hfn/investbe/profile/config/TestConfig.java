package br.com.hfn.investbe.profile.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hfn.investbe.enums.FinancialAssetCategoryEnum;
import br.com.hfn.investbe.enums.FinancialTransactionEventTypeEnum;
import br.com.hfn.investbe.enums.RoleEnum;
import br.com.hfn.investbe.enums.StatusEnum;
import br.com.hfn.investbe.enums.UserStatusEnum;
import br.com.hfn.investbe.model.Adress;
import br.com.hfn.investbe.model.AdressCity;
import br.com.hfn.investbe.model.AdressCountry;
import br.com.hfn.investbe.model.AdressState;
import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.model.Company;
import br.com.hfn.investbe.model.FinancialAsset;
import br.com.hfn.investbe.model.FinancialTransaction;
import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.StockExchange;
import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.model.Wallet;
import br.com.hfn.investbe.repository.AdressCityRepository;
import br.com.hfn.investbe.repository.AdressCountryRepository;
import br.com.hfn.investbe.repository.AdressStateRepository;
import br.com.hfn.investbe.repository.CompanyRepository;
import br.com.hfn.investbe.repository.FinancialAssetQuoteRepository;
import br.com.hfn.investbe.repository.FinancialAssetRepository;
import br.com.hfn.investbe.repository.FinancialTransactionTypeRepository;
import br.com.hfn.investbe.repository.RoleRepository;
import br.com.hfn.investbe.repository.StockExchangeRepository;
import br.com.hfn.investbe.repository.UserStatusRepository;
import br.com.hfn.investbe.service.BrokerService;
import br.com.hfn.investbe.service.FinancialAssetCategoryService;
import br.com.hfn.investbe.service.UserService;
import br.com.hfn.investbe.service.WalletService;

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
	private FinancialAssetCategoryService financialAssetCategoryService;
	@Autowired
	private AdressCityRepository adressCityRepository;
	@Autowired
	private AdressCountryRepository adressCountryRepository;
	@Autowired
	private AdressStateRepository adressStateRepository;
	/*@Autowired
	private BrokerRepository brokerRepository;*/
	@Autowired
	private BrokerService brokerService;
	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private FinancialAssetRepository financialAssetRepository;
	@Autowired
	private FinancialAssetQuoteRepository financialAssetQuoteRepository; 
	@Autowired
	private WalletService walletService;
	@Autowired
	private FinancialTransactionTypeRepository financialTransactionTypeRepository;
	
	
	@Value("${api.aplhavantage.key}")
	private String alphavantageKey;
	
	@Bean
	public boolean instantiateDatabase() {
		
		//ROLES
		roleRepo.save(RoleEnum.COMMOM.getModel());
		roleRepo.save(RoleEnum.ADM.getModel());
		//USER STATUS
		userStatusRepo.save(UserStatusEnum.ATIVO.getModel());
		userStatusRepo.save(UserStatusEnum.INATIVO.getModel());
		//FINANCIAL ASSET CATEGORIES
		financialAssetCategoryService.insert(FinancialAssetCategoryEnum.ACOES.getModel());
		financialAssetCategoryService.insert(FinancialAssetCategoryEnum.FIIS.getModel());
		financialAssetCategoryService.insert(FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel());
		financialAssetCategoryService.insert(FinancialAssetCategoryEnum.STOCKS.getModel());
		financialAssetCategoryService.insert(FinancialAssetCategoryEnum.REITS.getModel());
		//FINANCIAL TRANSACTION TYPE
		financialTransactionTypeRepository.save(FinancialTransactionEventTypeEnum.BUY.getModel());
		financialTransactionTypeRepository.save(FinancialTransactionEventTypeEnum.SELL.getModel());
		financialTransactionTypeRepository.save(FinancialTransactionEventTypeEnum.INPLIT.getModel());
		financialTransactionTypeRepository.save(FinancialTransactionEventTypeEnum.SPLIT.getModel());
		financialTransactionTypeRepository.save(FinancialTransactionEventTypeEnum.BONUS_SHARE.getModel());
		//COUNTRY
		AdressCountry brazil = new AdressCountry(null,1L,"Brazil");
		adressCountryRepository.save(brazil);
		//STATES
		AdressState rioDeJaneiro = new AdressState(null,1L,brazil,"RJ","Rio de Janeiro");
		AdressState saoPaulo = new AdressState(null,2L,brazil,"SP","São Paulo");
		adressStateRepository.saveAll(Arrays.asList(rioDeJaneiro,saoPaulo));
		//CITIES
		AdressCity cityRioDeJaneiro = new AdressCity(null,1L,rioDeJaneiro,"Rio de Janeiro");
		AdressCity citySaoPaulo = new AdressCity(null,2L,saoPaulo,"São Paulo");
		adressCityRepository.saveAll(Arrays.asList(cityRioDeJaneiro,citySaoPaulo));
		//BROKERS
		Adress adressRico = new Adress(null,citySaoPaulo, "VILA NOVA CONCEICAO", "Avenida Presidente Juscelino Kubitschek", "1400", "11 Andar", "04543000");
		Broker rico = new Broker(null, 1, StatusEnum.ATIVO, "RICO CORRETORA DE TITULOS E VALORES MOBILIARIOS S.A.", "13434335000160", adressRico);
		brokerService.save(rico);
		//EXCHANGES
		Adress adressB3 = new Adress(null,citySaoPaulo, "JARDIM PAULISTANO", "Avenida Brigadeiro Faria Lima", "1663", "Andar 2", "01452001");
		StockExchange b3 = new StockExchange(null, 1L, "B3 S.A. - BRASIL, BOLSA, BALCAO", "09346601001369", adressB3);
		stockExchangeRepository.save(b3);
		//COMPANIES
		//Adress adressAmbev = new Adress(null,citySaoPaulo, "JARDIM PAULISTANO", "Avenida Brigadeiro Faria Lima", "1663", "Andar 2", "01452001");
		Company ambev = new Company(null,1L, "AMBEV S/A", "07526557000100", null);
		Company bancoBradesco = new Company(null,2L, "BANCO BRADESCO", "60746948000112", null);
		Company engieBrasil = new Company(null,3L, "ENGIE BRASIL ENERGIA S.A.", "02474103000119", null);
		Company grendene = new Company(null,4L, "GRENDENE S.A.", "89850341000160", null);
		Company itau = new Company(null,5L, "ITAU UNIBANCO HOLDING S.A.", "60872504000123", null);
		Company lojasRenner = new Company(null,6L, "LOJAS RENNER S.A.", "92754738000162", null);
		Company mdiasBranco = new Company(null,7L, "M.DIAS BRANCO S.A. IND COM DE ALIMENTOS", "07206816000115", null);
		Company odontoPrev = new Company(null,8L, "ODONTOPREV S.A.", "58119199000151", null);
		Company raiaDrogasil = new Company(null,9L, "RAIA DROGASIL S.A.", "61585865000151", null);
		Company wegSa = new Company(null,10L, "WEG S.A.", "84429695000111", null);
		Company vivo = new Company(null,11L, "TELEFÔNICA BRASIL S.A", "02558157000162", null);
		Company bbse = new Company(null,12L, "BB SEGURIDADE PARTICIPAÇÕES S.A.", "17344597000194", null);
		
		Company cp_abcp11 = new Company(null,13L, "Grand Plaza Shopping", "01201140000190", null);
		Company cp_bcri11 = new Company(null,14L, "BANESTES RECEBÍVEIS IMOBILIÁRIOS", "22219335000138", null);
		Company cp_rcrb11 = new Company(null,15L, "Rio Bravo Renda Corporativa", "03683056000186", null);
		Company cp_ggrc11 = new Company(null,16L, "GGR Covepi Renda", "26614291000100", null);
		Company cp_hgbs11 = new Company(null,17L, "HEDGE BRASIL SHOPPING", "08431747000106", null);
		Company cp_hgpo11 = new Company(null,18L, "CSHG Prime Offices", "11260134000168", null);
		Company cp_hglg11 = new Company(null,19L, "CSHG Logística", "11728688000147", null);
		Company cp_hgre11 = new Company(null,20L, "CSHG Real Estate", "09072017000129", null);
		Company cp_knri11 = new Company(null,21L, "Kinea Renda Imobiliária", "12005956000165", null);
		Company cp_visc11 = new Company(null,22L, "Vinci Shopping Centers", "17554274000125", null);
		Company cp_vrta11 = new Company(null,23L, "Fator Verita", "11664201000100", null);
		Company cp_xpml11 = new Company(null,24L, "XP Malls","28757546000100", null);
		companyRepository.saveAll(Arrays.asList(
				ambev, bancoBradesco, engieBrasil, grendene, itau, lojasRenner, mdiasBranco, odontoPrev,
				raiaDrogasil, wegSa, vivo, bbse, cp_abcp11, cp_bcri11, cp_rcrb11, cp_ggrc11, cp_hgbs11, cp_hgpo11, cp_hglg11,
				cp_hgre11, cp_knri11, cp_visc11, cp_vrta11, cp_xpml11));
		//FINANCIAL ASSETS
		FinancialAsset ipca2045 = new FinancialAsset(null, 1L, b3, "IPCA_2045", null, FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel(), LocalDateTime.now(), null, null);
		FinancialAsset selic2023 = new FinancialAsset(null, 2L, b3, "SELIC_2023", null, FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel(), LocalDateTime.now(), null, null);
		FinancialAsset prefixado2025 = new FinancialAsset(null, 3L, b3, "PREFICADO_2025", null, FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel(), LocalDateTime.now(), null, null);
		FinancialAsset selic2025 = new FinancialAsset(null, 4L, b3, "SELIC_2025", null, FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel(), LocalDateTime.now(), null, null);
		FinancialAsset selic2027 = new FinancialAsset(null, 5L, b3, "SELIC_2027", null, FinancialAssetCategoryEnum.TESOURO_DIRETO.getModel(), LocalDateTime.now(), null, null);
		FinancialAsset abev3 = new FinancialAsset(null, 6L, b3, "ABEV3", ambev, FinancialAssetCategoryEnum.ACOES.getModel(), LocalDateTime.now(), null, null);
		FinancialAsset hglg11 = new FinancialAsset(null, 7L, b3, "HGLG11", cp_hglg11, FinancialAssetCategoryEnum.FIIS.getModel(), LocalDateTime.now(), null, null);
		financialAssetRepository.saveAll(Arrays.asList(ipca2045, selic2023, prefixado2025, selic2025, selic2027, abev3, hglg11));
		
		//Criar eventos corporativos: Dividendos, J sobre capital proprio, Bonificação, subscrição, desdobramento(split), Grupamento(inplit)
		
		//Get all quotes monthly exemple
		/*ApiConnector connector = new AlphaVantageConnector(alphavantageKey,6000);
		TimeSeries timeSeries = new TimeSeries(connector);
		Monthly monthly = timeSeries.monthly("ABEV3.SA");
		List<StockData> listaABEV3 = monthly.getStockData();
		
		List<FinancialAssetQuote> listaQuoteToSave = listaABEV3.stream().map(obj -> new FinancialAssetQuote(obj, abev3)).collect(Collectors.toList());
		financialAssetQuoteRepository.saveAll(listaQuoteToSave);
		*/
		
		//TEST USER
		List<Role> roles1 = new ArrayList<>();
		roles1.add(RoleEnum.COMMOM.getModel());
		roles1.add(RoleEnum.ADM.getModel());
		List<Role> roles2 = new ArrayList<>();
		roles2.add(RoleEnum.COMMOM.getModel());
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
		userService.insert(userAdm);
		userService.insert(userCommon);
				
		//Create wallet
		Wallet wallet = new Wallet();
		wallet.setUser(userAdm);
		wallet.setDhCreated(LocalDateTime.now());
		wallet = walletService.save(wallet);
		
		//Create transations
		FinancialTransaction ft1 = new FinancialTransaction(null,LocalDateTime.now().minusDays(5L),wallet,abev3,FinancialTransactionEventTypeEnum.BUY.getModel(),100,8.18D,0D);
		FinancialTransaction ft2 = new FinancialTransaction(null,LocalDateTime.now().minusDays(3L),wallet,abev3,FinancialTransactionEventTypeEnum.SELL.getModel(),30,8.59D,0D);
		FinancialTransaction ft3 = new FinancialTransaction(null,LocalDateTime.now(),wallet,abev3,FinancialTransactionEventTypeEnum.BUY.getModel(),100,9.23D,0D);
		FinancialTransaction ft4 = new FinancialTransaction(null,LocalDateTime.now(),wallet,hglg11,FinancialTransactionEventTypeEnum.BUY.getModel(),10,120D,0D);
		walletService.addTransactions(Arrays.asList(ft1,ft2,ft3,ft4));
		walletService.save(wallet);
		
		
		return true;
	}
	
}
