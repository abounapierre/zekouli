package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.AnneeScolaireBusinessService;
import com.abouna.zekouli_bo.data.models.AnneeScolaireDto;

@RestController
@RequestMapping("/annee-scolaires")
public class AnneeScolaireController extends AbstractRestControllerImpl<AnneeScolaireDto, Long>{

	public AnneeScolaireController(AnneeScolaireBusinessService service) {
		super(service);
	}

}
