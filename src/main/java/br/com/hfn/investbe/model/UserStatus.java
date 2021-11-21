package br.com.hfn.investbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.hfn.investbe.dto.UserStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="USER_STATUS")
public class UserStatus {

	@Id
	@Column(name="cd_user_status", length = 2)
	private Integer code;
	
	@Column(name="ds_name", length = 50)
	private String name;
	
	public UserStatus(UserStatusDTO dto) {
		this.code = dto.getCode();
		this.name = dto.getName();
	}
}
