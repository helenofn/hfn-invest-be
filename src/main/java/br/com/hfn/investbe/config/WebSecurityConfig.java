package br.com.hfn.investbe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import br.com.hfn.investbe.config.provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final JwtTokenProvider jwtTokenProvider;
	
	/*protected void configure(HttpSecurity http)throws Exception {
		
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
	}*/
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .headers()
            .frameOptions()
            .sameOrigin()
            .httpStrictTransportSecurity()
            .includeSubDomains(true)
            .maxAgeInSeconds(31536000)
        .and()
        	.contentSecurityPolicy("script-src 'self' 'unsafe-inline' ");
		
        http.httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .antMatchers("/h2-console/**","/auth/**","/dominio/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .apply(new JwtConfig(jwtTokenProvider));
    }
	
	
}
