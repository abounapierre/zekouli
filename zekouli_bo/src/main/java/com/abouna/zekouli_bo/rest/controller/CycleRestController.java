package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.CycleBusinessService;
import com.abouna.zekouli_bo.data.dtos.CycleDto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cycles")
public class CycleRestController extends AbstractRestControllerImpl<CycleDto, Long> {
	
	public CycleRestController(CycleBusinessService service) {
		super(service);
		this.service = service;
	}

	private final CycleBusinessService service;

	@ApiOperation(value = "Récupère la liste des cycles selon un etablissement à partir de son id")
	@GetMapping("/etablissement/{id}")
	public List<CycleDto> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}

}
