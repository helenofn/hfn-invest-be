package br.com.hfn.investbe.model.meta;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.hfn.investbe.model.User;
import br.com.hfn.investbe.model.UserStatus;

@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, UserStatus> status;
	
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String NAME = "name";
	public static final String STATUS = "status";
}
