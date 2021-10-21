package br.com.hfn.investbe.commom.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.hfn.investbe.commom.model.User;

public class UserSpecification {
	
	public static Specification<User> emailLike(String email){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.like(root.get(User_.EMAIL), "%"+email+"%");
	}
	
	public static Specification<User> nameLike(String name){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.like(root.get(User_.NAME), "%"+name+"%");
	}
	
	public static Specification<User> statusCodeEquals(Integer statusCode){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.equal(root.get(User_.STATUS).get(UserStatus_.CODE), statusCode);
	}


}
