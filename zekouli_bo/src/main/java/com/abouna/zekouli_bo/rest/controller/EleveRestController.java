package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.EleveBusinessService;
import com.abouna.zekouli_bo.data.dtos.EleveDto;
import com.abouna.zekouli_bo.data.dtos.EleveInscritDto;

@RestController
@RequestMapping("/eleves")
public class EleveRestController extends AbstractRestControllerImpl<EleveDto, Long>{
	private final EleveBusinessService service;
	public EleveRestController(EleveBusinessService service) {
		super(service);
		this.service = service;
	}
	
	@GetMapping("/inscrit/anneeScolaire")
	public List<EleveInscritDto> getListeEleveInscrits(@RequestParam("id") Long id){
		return service.getListeEleveInscrits(id);
	}
	
	@GetMapping("/recherche")
	public List<EleveDto> getListeEleveParNomOuMatricule(@RequestParam("matricule") String matricule,@RequestParam("nom") String nom){
		return service.getListeEleveParNomOuMatricule(matricule,nom);
	}
}
