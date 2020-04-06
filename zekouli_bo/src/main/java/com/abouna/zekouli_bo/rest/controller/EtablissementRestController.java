package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.EtablissementBusinessService;
import com.abouna.zekouli_bo.data.dtos.EtablissementDto;

@RestController
@RequestMapping("/etablissements")
public class EtablissementRestController extends AbstractRestControllerImpl<EtablissementDto, Long>{
	
	public EtablissementRestController(EtablissementBusinessService service) {
		super(service);
	}
	
}
