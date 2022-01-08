package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.hfn.investbe.response.dto.RoleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Role entity - Maps access to Role data
 * @author Heleno
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ROLE")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 8609711534395269143L;
	
	@Id
	@Column(name="cd_role", length = 3)
	private Integer code;
	
	@Column(name="ds_name", unique=true, length = 50)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<>();
	
	public Role(RoleResponseDTO dto) {
		this.code = dto.getCode();
		this.name = dto.getName();
	}

}
