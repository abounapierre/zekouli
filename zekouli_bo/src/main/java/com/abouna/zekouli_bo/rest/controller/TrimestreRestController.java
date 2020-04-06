package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.TrimestreBusinessService;
import com.abouna.zekouli_bo.data.dtos.TrimestreDto;

@RestController
@RequestMapping("/trimestres")
public class TrimestreRestController extends AbstractRestControllerImpl<TrimestreDto, Long>{

	public TrimestreRestController(TrimestreBusinessService service) {
		super(service);
	}

}
