package br.com.hfn.investbe.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hfn.investbe.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable{
	private static final long serialVersionUID = -1981657228272235064L;
	
	private String name;
	private Long id;
	private String email;
	private String password;
	private UserStatusDTO status;
	private List<RoleDTO> roles;
	
	public UserDTO(User obj) {
		super();
		if(null!=obj) {
			this.id = obj.getId();
			this.name = obj.getName();
			this.email = obj.getEmail();
			this.status = new UserStatusDTO(obj.getStatus());
			this.roles = obj.getRoles().stream().map(o -> new RoleDTO(o)).collect(Collectors.toList());
		}
	}
}