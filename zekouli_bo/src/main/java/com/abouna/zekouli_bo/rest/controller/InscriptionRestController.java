package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.InscriptionBusinessService;
import com.abouna.zekouli_bo.data.dtos.InscriptionDto;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionRestController extends AbstractRestControllerImpl<InscriptionDto, Long>{
	private final InscriptionBusinessService service;

	public InscriptionRestController(InscriptionBusinessService service) {
		super(service);
		this.service = service;
	}
	
	@GetMapping("/{idAnnee}/{idEleve}")
	public InscriptionDto getInscriptionParAnnee(@PathVariable("idAnnee") Long idAnnee, @PathVariable("idEleve") Long idEleve) {
		return service.getInscriptionParAnnee(idAnnee,idEleve);
	}
	
	@GetMapping("/recherche")
	public List<InscriptionDto> getInscriptionParClasse(@RequestParam("classe") Long idClasse, @RequestParam("anneeScolaire") Long idAnnee) {
		return service.getInscriptionParClasse(idClasse,idAnnee);
	}

}
