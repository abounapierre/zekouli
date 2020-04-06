package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.NiveauBusinessService;
import com.abouna.zekouli_bo.data.dtos.NiveauDto;

@RestController
@RequestMapping("/niveaux")
public class NiveauRestController extends AbstractRestControllerImpl<NiveauDto, Long> {
	
	public NiveauRestController(NiveauBusinessService service) {
		super(service);
		this.service = service;
	}

	private final NiveauBusinessService service;

	
	@GetMapping("/etablissement/{id}")
	public List<NiveauDto> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}
	
	@GetMapping("/cycle/{id}")
	public List<NiveauDto> getListeParCycle(@PathVariable Long id){
		return service.getListeParCycle(id);
	}
	
}
