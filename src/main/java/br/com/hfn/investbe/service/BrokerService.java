package br.com.hfn.investbe.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.hfn.investbe.exception.HfnInvestException;
import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.model.specification.BrokerSpecification;
import br.com.hfn.investbe.repository.BrokerRepository;
import br.com.hfn.investbe.request.dto.BrokerFilterRequestDTO;
import br.com.hfn.investbe.validator.annotations.BrokerInsert;
import br.com.hfn.investbe.validator.annotations.BrokerUpdate;
import lombok.RequiredArgsConstructor;

@Validated
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
	
	public Broker save(@Valid @BrokerInsert Broker broker) {
		return brokerRepository.save(broker);
	}
	
	public Broker update(@Valid @BrokerUpdate Broker broker) {
		Broker newObj = findBySeqId(broker.getSeqId()).orElseThrow(()->new HfnInvestException("A corretora informada não foi encontrada",true));
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
			BrokerFilterRequestDTO filtro){
		
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
