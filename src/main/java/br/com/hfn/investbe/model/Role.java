package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.hfn.investbe.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable{
	
	private static final long serialVersionUID = 8609711534395269143L;
	
	@Id
	private Integer code;
	
	@Column(name="name", unique=true, length = 60)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<>();
	
	public Role(RoleDTO dto) {
		this.code = dto.getCode();
		this.name = dto.getName();
	}

}
