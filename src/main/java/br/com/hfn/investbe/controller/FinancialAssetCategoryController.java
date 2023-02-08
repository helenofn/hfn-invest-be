package br.com.hfn.investbe.controller;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import br.com.hfn.investbe.request.dto.NewFinancialAssetCategoryRequestDTO;
import br.com.hfn.investbe.response.dto.FinancialAssetCategoryResponseDTO;
import br.com.hfn.investbe.service.FinancialAssetCategoryService;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping(value = "/financialAssetCategory")
@RequiredArgsConstructor
public class FinancialAssetCategoryController extends CommonController{

	private final FinancialAssetCategoryService financialAssetCategoryService;
	private final ModelMapper modelMapper;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FinancialAssetCategoryResponseDTO> getFinancialAssetCategory(@PathVariable Integer id ){
		FinancialAssetCategory model = financialAssetCategoryService.findById(id).orElse(null);
		return ResponseEntity.ok(modelMapper.map(model, FinancialAssetCategoryResponseDTO.class));
	}
	
	@PostMapping
	public ResponseEntity<FinancialAssetCategoryResponseDTO> save(@RequestBody @Valid NewFinancialAssetCategoryRequestDTO dto){
		FinancialAssetCategory model = modelMapper.map(dto, FinancialAssetCategory.class);
		model = financialAssetCategoryService.insert(model);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getId()).toUri();
		return ResponseEntity.created(uri).body(modelMapper.map(model, FinancialAssetCategoryResponseDTO.class));
	}
	
	
}
