package br.com.hfn.investbe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hfn.investbe.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{

}
