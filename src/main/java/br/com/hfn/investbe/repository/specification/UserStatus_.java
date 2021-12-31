package br.com.hfn.investbe.repository.specification;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.hfn.investbe.model.user.User;
import br.com.hfn.investbe.model.user.UserStatus;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class UserStatus_ {

	public static volatile SingularAttribute<UserStatus, Integer> code;
	public static volatile SingularAttribute<User, String> name;
	
	public static final String CODE = "code";
	public static final String NAME = "name";
}
