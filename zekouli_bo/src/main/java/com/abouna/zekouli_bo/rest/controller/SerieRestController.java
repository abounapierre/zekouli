package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.SerieBusinessService;
import com.abouna.zekouli_bo.data.dtos.SerieDto;

@RestController
@RequestMapping("/series")
public class SerieRestController extends AbstractRestControllerImpl<SerieDto, Long> {
	
	public SerieRestController(SerieBusinessService service) {
		super(service);
		this.service = service ;
	}

	private final SerieBusinessService service;
	
	@GetMapping("/etablissement/{id}")
	public List<SerieDto> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}
}
