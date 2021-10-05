package br.com.hfn.investbe.common.transformer;

import java.util.ArrayList;

import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.common.dto.UserDTO;
import br.com.hfn.investbe.common.exception.HfnInvestException;

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
}
