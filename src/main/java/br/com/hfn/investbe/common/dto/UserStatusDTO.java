package br.com.hfn.investbe.common.dto;

import java.io.Serializable;

import br.com.hfn.investbe.commom.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusDTO implements Serializable{
	
	private static final long serialVersionUID = 2359969994699082817L;
	
	private Integer code;
	private String name;
	
	public UserStatusDTO(UserStatus obj){
		if(null!=obj) {
			this.code = obj.getCode();
			this.name = obj.getName();			
		}
	}
	
}
