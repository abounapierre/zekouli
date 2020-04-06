package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.AnneeScolaireBusinessService;
import com.abouna.zekouli_bo.data.dtos.AnneeScolaireDto;

import io.swagger.annotations.Api;

@Api("API pour es opérations CRUD sur les années solaires.")
@RestController
@RequestMapping("/annee-scolaires")
public class AnneeScolaireController extends AbstractRestControllerImpl<AnneeScolaireDto, Long>{
	private final AnneeScolaireBusinessService anneeScolaireBusinessService;

	public AnneeScolaireController(AnneeScolaireBusinessService service) {
		super(service);
		this.anneeScolaireBusinessService = service;
	}
	
	@GetMapping("/encours")
	public AnneeScolaireDto getAnneeScolaireEncours() {
		return anneeScolaireBusinessService.getAnneeScolaireEncours();
	}
	
	@GetMapping("/recherche")
	public AnneeScolaireDto getAnneeScolaireParCode(@RequestParam("code") String code) {
		return anneeScolaireBusinessService.getAnneeScolaireParCode(code);
	}

}
