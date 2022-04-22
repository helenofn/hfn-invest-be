package br.com.hfn.investbe.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfn.investbe.model.Broker;
import br.com.hfn.investbe.request.dto.BrokerRequestDTO;
import br.com.hfn.investbe.request.dto.FilterBrokerRequestDTO;
import br.com.hfn.investbe.request.dto.NewBrokerRequestDTO;
import br.com.hfn.investbe.response.dto.BrokerResponseDTO;
import br.com.hfn.investbe.service.BrokerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/broker")
@RequiredArgsConstructor
public class BrokerController {

	private final BrokerService brokerService;
	
	@PostMapping
	public ResponseEntity<BrokerResponseDTO> insert(@Valid @RequestBody NewBrokerRequestDTO newBrokerDto){
		Broker broker = new Broker(newBrokerDto);
		broker = brokerService.save(broker);
		return ResponseEntity.ok().body(new BrokerResponseDTO(broker));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BrokerResponseDTO> update(@Valid @RequestBody BrokerRequestDTO brokerDto, @PathVariable Integer id){
		Broker broker = new Broker(brokerDto);
		broker.setSeqId(id);
		broker = brokerService.update(broker);
		return ResponseEntity.ok().body(new BrokerResponseDTO(broker));
	}
	
	@PostMapping(value = "/page")
	public ResponseEntity<Page<BrokerResponseDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "15") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestBody FilterBrokerRequestDTO filtro){
		
		Page<Broker> list = brokerService.findPage(page, linesPerPage, direction, orderBy, filtro);
		Page<BrokerResponseDTO> listDto = list.map(obj -> new BrokerResponseDTO(obj));
        return ResponseEntity.ok().body(listDto);
		
	}
	
	
}