package br.com.hfn.investbe.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.hfn.investbe.security.filter.JwtTokenFilter;
import br.com.hfn.investbe.security.provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final JwtTokenProvider jwtTokenProvider;
	
	protected void configure(HttpSecurity http)throws Exception {
		
		JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
						
		http
			.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
			.headers()
			.frameOptions().sameOrigin()
			.httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000)
			.and()
			.contentSecurityPolicy("script-src 'self' 'unsafe-inline' ");
		
		http.httpBasic().disable()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers("/h2-console/**","/auth/**","/user/**", "/dominio/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
