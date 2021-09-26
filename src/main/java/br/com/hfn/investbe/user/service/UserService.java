package br.com.hfn.investbe.user.service;

import br.com.hfn.investbe.commom.model.User;

public interface UserService {

	public User save(User user);
	
	public User findById(Long id);
	
}
