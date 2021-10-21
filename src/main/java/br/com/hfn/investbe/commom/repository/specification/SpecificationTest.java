package br.com.hfn.investbe.commom.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface SpecificationTest <T>{

	Predicate toPredicate(Root<T> root, CriteriaQuery<T> query, CriteriaBuilder builder);
}



