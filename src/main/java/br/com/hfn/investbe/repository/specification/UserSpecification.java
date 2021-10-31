package br.com.hfn.investbe.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.hfn.investbe.model.User;

public class UserSpecification {
	
	public static Specification<User> emailLike(String email){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.like(criteriaBuilder.upper(root.get(User_.EMAIL)), "%"+email.toUpperCase()+"%");
	}
	
	public static Specification<User> nameLike(String name){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.like(criteriaBuilder.upper(root.get(User_.NAME)), "%"+name.toUpperCase()+"%");
	}
	
	public static Specification<User> statusCodeEquals(Integer statusCode){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.equal(root.get(User_.STATUS).get(UserStatus_.CODE), statusCode);
	}


}
