package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_user_status")
	private UserStatus status;
	
	@Builder.Default
	@ManyToMany
	@JoinTable(	name = "USER_ROLE",
				joinColumns = {@JoinColumn(name = "cseq_user")}, 
				inverseJoinColumns = {@JoinColumn(name = "cd_role")})
	private List<Role> roles = new ArrayList<Role>();

}
