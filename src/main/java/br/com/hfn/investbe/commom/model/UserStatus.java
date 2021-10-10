package br.com.hfn.investbe.commom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER_STATUS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserStatus {

	@Id
	private Integer code;
	@Column(name="name", length = 60)
	private String name;
}
