package br.com.hfn.investbe.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hfn.investbe.dominio.service.FinancialAssetCategoryService;
import br.com.hfn.investbe.dto.FinancialAssetCategoryDTO;
import br.com.hfn.investbe.model.FinancialAssetCategory;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/financialAssetCategory")
@RequiredArgsConstructor
public class FinancialAssetCategoryController {

	private final FinancialAssetCategoryService financialAssetCategoryService;
	
	@PostMapping
	public ResponseEntity<FinancialAssetCategoryDTO> save(@RequestBody FinancialAssetCategoryDTO dto){
		FinancialAssetCategory model = new FinancialAssetCategory(dto);
		model = financialAssetCategoryService.save(model);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getId()).toUri();
		return ResponseEntity.created(uri).body(new FinancialAssetCategoryDTO(model));
	}
	
	
}
