package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.ClasseBusinessService;
import com.abouna.zekouli_bo.data.models.ClasseDto;

@RestController
@RequestMapping("/classes")
public class ClasseRestController extends AbstractRestControllerImpl<ClasseDto, Long>{
	
	
	public ClasseRestController(ClasseBusinessService service) {
		super(service);
		this.service = service;
	}

	private final ClasseBusinessService service;

	
	@GetMapping("/cycle/{id}")
	public List<ClasseDto> getListeParCycle(@PathVariable Long id){
		return service.getListeParCycle(id);
	}
	
	@GetMapping("/serie/{id}")
	public List<ClasseDto> getListeParSerie(@PathVariable Long id){
		return service.getListeParSerie(id);
	}
	
	@GetMapping("/niveau/{id}")
	public List<ClasseDto> getListeParNiveau(@PathVariable Long id){
		return service.getListeParNiveau(id);
	}
	
	@GetMapping("/etablissement/{id}")
	public List<ClasseDto> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}

}
