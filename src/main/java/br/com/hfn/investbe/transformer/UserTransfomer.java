package br.com.hfn.investbe.transformer;

import java.util.ArrayList;

import br.com.hfn.investbe.dto.UserDTO;
import br.com.hfn.investbe.dto.UserNewDTO;
import br.com.hfn.investbe.exception.HfnInvestException;
import br.com.hfn.investbe.model.User;

public class UserTransfomer {

	private UserTransfomer() {
		throw new HfnInvestException("Utility class",false);
	}
	
	public static UserDTO getDtoFromModel(User model) {
		return UserDTO.builder()
				.email(model.getEmail())
				.id(model.getId())
				.name(model.getName()).build();
	}
	
	public static User getModelFromDto(UserDTO dto) {
		User user = User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.password(dto.getPassword())
				.email(dto.getEmail()).build();
		user.setRoles(new ArrayList<>());
		return user;
	}
	
	public static User getModelFromNewDto(UserNewDTO dto) {
		User user = User.builder()
				.name(dto.getName())
				.password(dto.getPassword())
				.email(dto.getEmail()).build();
		user.setRoles(new ArrayList<>());
		return user;
	}
}
