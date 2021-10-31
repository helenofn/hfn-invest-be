package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Entity - Maps access to user data
 * @author Heleno
 *
 */
@Entity
@Table(name="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable{

	private static final long serialVersionUID = 1686965569693368471L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email", unique=true)
	private String email;
	@Column(name="cript_pass", length = 60)
	private String password;
	private String name;
	@ManyToOne
	@JoinColumn(name = "code")
	private UserStatus status;
	
	@ManyToMany
	@JoinTable(	name = "USER_ROLE",
				joinColumns = {@JoinColumn(name = "user_id")}, 
				inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> roles = new ArrayList<Role>();
	
	public User(UserDTO userDto) {
		super();
		this.id = userDto.getId();
		this.email = userDto.getEmail();
		this.name = userDto.getName();
		this.password = userDto.getPassword();
		this.status = new UserStatus(userDto.getStatus());
	}
	
}
