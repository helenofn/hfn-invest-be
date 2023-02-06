package br.com.hfn.investbe.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import br.com.hfn.investbe.response.dto.FinancialAssetCategoryResponseDTO;
import br.com.hfn.investbe.service.FinancialAssetCategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/financialAssetCategory")
@RequiredArgsConstructor
public class FinancialAssetCategoryController extends CommonController{

	private final FinancialAssetCategoryService financialAssetCategoryService;
	private final ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<FinancialAssetCategoryResponseDTO> save(@RequestBody FinancialAssetCategoryResponseDTO dto){
		FinancialAssetCategory model = new FinancialAssetCategory(dto);
		model = financialAssetCategoryService.save(model);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getId()).toUri();
		return ResponseEntity.created(uri).body(modelMapper.map(model, FinancialAssetCategoryResponseDTO.class));
	}
	
	
}
