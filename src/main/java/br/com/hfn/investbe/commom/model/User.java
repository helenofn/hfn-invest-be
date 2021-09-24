package br.com.hfn.investbe.commom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Entity - Maps access to user data
 * @author Heleno
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 1686965569693368471L;
	
	@Id
	private Long id;
	
	@Column(name="email", unique=true)
	private String email;
	private String password;
	private String nome;
	
}
