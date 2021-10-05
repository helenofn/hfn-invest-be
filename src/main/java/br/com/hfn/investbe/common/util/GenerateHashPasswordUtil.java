package br.com.hfn.investbe.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GenerateHashPasswordUtil {
	
	public static String getHasFromPassword(String pass) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(pass);
	}
	
	public static boolean isPasswordMatch(String pass1, String pass2) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(pass1, pass2);
	}
	
}

