package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.TypeEtablissmentBusinessService;
import com.abouna.zekouli_bo.data.models.TypeEtablissementDto;

@RestController
@RequestMapping("/type-etablissements")
public class TypeEtablissementRestController extends AbstractRestControllerImpl<TypeEtablissementDto, Long> {

	public TypeEtablissementRestController(TypeEtablissmentBusinessService service) {
		super(service);
	}
}
