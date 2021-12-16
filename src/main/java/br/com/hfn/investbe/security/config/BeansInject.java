package br.com.hfn.investbe.security.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeansInject {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
