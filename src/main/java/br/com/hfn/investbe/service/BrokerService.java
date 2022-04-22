package br.com.hfn.investbe.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.hfn.investbe.exception.HfnInvestException;
import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.model.specification.BrokerSpecification;
import br.com.hfn.investbe.repository.BrokerRepository;
import br.com.hfn.investbe.request.dto.FilterBrokerRequestDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrokerService extends BrokerSpecification{
	
	private final BrokerRepository brokerRepository;
	
	public Optional<Broker> findBySeqId(Integer seqId){
		return brokerRepository.findById(seqId);
	}
	
	public Optional<Broker> findByEin(String ein){
		return brokerRepository.findByEin(ein);
	}
	
	public Optional<Broker> findByInternalId(Integer internalId){
		return brokerRepository.findByInternalId(internalId);
	}

	
	public Broker save(Broker broker) {
		if(findByEin(broker.getEin()).isPresent()) {
			throw new HfnInvestException("A corretora informada já existe",true);
		}
		
		if(findByInternalId(broker.getInternalId()).isPresent()) {
			throw new HfnInvestException("Já existe um outro registro de corretora usando o id interno informado",true);
		}
		
		return brokerRepository.save(broker);
	}
	
	public Broker update(Broker broker) {
		Broker newObj = findBySeqId(broker.getSeqId()).orElseThrow(()->new HfnInvestException("A corretora informada não foi encontrada",true));
		
		if(!newObj.getEin().equalsIgnoreCase(broker.getEin())) {
			if(findByEin(broker.getEin()).isPresent()) {
				throw new HfnInvestException("Já existe um outro registro de corretora usando o CNPJ informado",true);
			}
		}
		
		if(!newObj.getInternalId().equals(broker.getInternalId())) {
			if(findByInternalId(broker.getInternalId()).isPresent()) {
				throw new HfnInvestException("Já existe um outro registro de corretora usando o id interno informado",true);
			}
		}
		
		newObj.setEin(broker.getEin());
		newObj.setInternalId(broker.getInternalId());
		newObj.setMainAdress(broker.getMainAdress());
		newObj.setName(broker.getName());
		return brokerRepository.save(newObj);
	}
	
	public Page<Broker> findPage(
			Integer page, 
			Integer linesPerPage, 
			String direction, 
			String orderBy, 
			FilterBrokerRequestDTO filtro){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Specification<Broker> specification = 
				Specification
					.where(seqIdEqual(filtro.getSeqId()))
					.and(internalIdEqual(filtro.getInternalId()))
					.and(nameLike(filtro.getName()))
					.and(einLike(filtro.getEin()));
		
		return brokerRepository.findAll(specification,pageRequest);
	}

}
