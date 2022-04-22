package br.com.hfn.investbe.model.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.model.meta.Broker_;
import br.com.hfn.investbe.util.StringUtil;

public class BrokerSpecification {

	public static Specification<Broker> seqIdEqual(Integer seqId){
		return (root, query, criteriaBuilder) -> {
			if(null==seqId) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.equal(criteriaBuilder.upper(root.get(Broker_.SEQ_ID)), seqId);
		};
	}
	
	public static Specification<Broker> internalIdEqual(Integer internalId){
		return (root, query, criteriaBuilder) -> {
			if(null==internalId) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.equal(criteriaBuilder.upper(root.get(Broker_.INTERNAL_ID)), internalId);
		};
	}
	
	public static Specification<Broker> nameLike(String name){
		return (root, query, criteriaBuilder) -> {
			if(StringUtil.isEmpty(name)) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.like(criteriaBuilder.upper(root.get(Broker_.NAME)), "%"+name.toUpperCase()+"%");
		};
	}
	
	public static Specification<Broker> einLike(String ein){
		return (root, query, criteriaBuilder) -> {
			if(StringUtil.isEmpty(ein)) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.like(criteriaBuilder.upper(root.get(Broker_.EIN)), "%"+ein.toUpperCase()+"%");
		};
	}
}
