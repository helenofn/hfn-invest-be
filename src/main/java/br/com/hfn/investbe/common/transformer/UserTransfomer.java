package br.com.hfn.investbe.common.transformer;

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
		return User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.password(dto.getPassword())
				.email(dto.getEmail()).build();
	}
}
