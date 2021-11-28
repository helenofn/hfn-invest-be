package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.hfn.investbe.dto.UserDTO;
import br.com.hfn.investbe.dto.UserNewDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Entity - Maps access to user data
 * @author Heleno
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="USER")
public class User implements Serializable{

	private static final long serialVersionUID = 1686965569693368471L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cseq_user", length = 22)
	private Long id;
	
	@Column(name="ds_email", unique=true)
	private String email;
	
	@Column(name="ds_cript_pass", length = 60)
	private String password;
	
	@Column(name="ds_name", length = 100)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "cd_user_status")
	private UserStatus status;
	
	@ManyToMany
	@JoinTable(	name = "USER_ROLE",
				joinColumns = {@JoinColumn(name = "cseq_user")}, 
				inverseJoinColumns = {@JoinColumn(name = "cd_role")})
	private List<Role> roles = new ArrayList<Role>();
	
	public User(UserDTO userDto) {
		super();
		this.id = userDto.getId();
		this.email = userDto.getEmail();
		this.name = userDto.getName();
		this.password = userDto.getPassword();
		this.status = new UserStatus(userDto.getStatus());
		this.roles = new ArrayList<Role>();
		this.roles.addAll(userDto.getRoles().stream().map(o -> new Role(o)).collect(Collectors.toList()));
	}
	
	public User(UserNewDTO userDto) {
		super();
		this.email = userDto.getEmail();
		this.name = userDto.getName();
		this.password = userDto.getPassword();
		this.roles = new ArrayList<Role>();
	}

}
