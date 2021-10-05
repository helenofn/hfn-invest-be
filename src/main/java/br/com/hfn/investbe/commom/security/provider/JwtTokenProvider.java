package br.com.hfn.investbe.commom.security.provider;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.hfn.investbe.commom.security.dto.AuthenticationResponseDTO;
import br.com.hfn.investbe.common.util.DateTimeUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

	private static final String ROLES = "roles";
	
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	
	@Value("${security.jwt.token.expire-lenth}")
	private String expereTime;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
	}
	
	public String createToken(String username, Collection<? extends GrantedAuthority> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put(ROLES, roles);
		
		
		Date valid = DateTimeUtil.getNowSumTimeDate(Long.valueOf(expereTime));
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(DateTimeUtil.getNowDate())
				.setExpiration(valid)
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearer = req.getHeader("authorization");
		if(null!=bearer && bearer.startsWith("Bearer ")) {
			return bearer.substring(7,bearer.length());
		}
		return null;
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		}catch(JwtException e) {
			return false;
		}
	}
	
	public Authentication getAuthentication(String token) {
		return new AuthenticationResponseDTO(getUserName(token), null, getRoles(token), null);
	}
	
	public Claims getJwtBody(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	public String getUserName(String token) {
		return getJwtBody(token).getSubject();
	}
	
	public Collection<GrantedAuthority> getRoles(String token){
		Claims claims = getJwtBody(token);
		return Arrays.stream(claims.get(ROLES).toString().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	
	
}
