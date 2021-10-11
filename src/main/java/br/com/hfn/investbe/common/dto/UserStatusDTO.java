package br.com.hfn.investbe.common.dto;

import br.com.hfn.investbe.commom.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusDTO {

	private Integer code;
	private String name;
	
	public UserStatusDTO(UserStatus obj){
		if(null!=obj) {
			this.code = obj.getCode();
			this.name = obj.getName();			
		}
	}
	
}
