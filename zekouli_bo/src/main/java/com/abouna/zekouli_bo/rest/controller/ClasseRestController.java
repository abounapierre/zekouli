package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.ClasseBusinessService;
import com.abouna.zekouli_bo.data.dtos.ClasseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API pour es opérations CRUD sur les classes.")
@RestController
@RequestMapping("/classes")
public class ClasseRestController extends AbstractRestControllerImpl<ClasseDto, Long>{
	
	
	public ClasseRestController(ClasseBusinessService service) {
		super(service);
		this.service = service;
	}

	private final ClasseBusinessService service;

	@ApiOperation(value = "Récupère la liste des classes selon un cycle à partir de son id")
	@GetMapping("/cycle/{id}")
	public List<ClasseDto> getListeParCycle(@PathVariable Long id){
		return service.getListeParCycle(id);
	}
	
	@ApiOperation(value = "Récupère la liste des classes selon une serie à partir de son id")
	@GetMapping("/serie/{id}")
	public List<ClasseDto> getListeParSerie(@PathVariable Long id){
		return service.getListeParSerie(id);
	}
	
	@ApiOperation(value = "Récupère la liste des classes selon un niveau à partir de son id")
	@GetMapping("/niveau/{id}")
	public List<ClasseDto> getListeParNiveau(@PathVariable Long id){
		return service.getListeParNiveau(id);
	}
	
	@ApiOperation(value = "Récupère la liste des classes selon un etablissement à partir de son id")
	@GetMapping("/etablissement/{id}")
	public List<ClasseDto> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}

}
