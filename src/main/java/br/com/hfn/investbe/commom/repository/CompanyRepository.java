package br.com.hfn.investbe.commom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hfn.investbe.commom.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{

}
