package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.TypeEtablissmentBusinessService;
import com.abouna.zekouli_bo.data.models.TypeEtablissementModel;

@RestController
@RequestMapping("/type-etablissements")
public class TypeEtablissementRestController implements AbstractRestController<TypeEtablissementModel, Long> {
	@Autowired
	private TypeEtablissmentBusinessService service;

	@Override
	public TypeEtablissementModel enregistrer(TypeEtablissementModel r) {
		return service.enregistrer(r);
	}

	@Override
	public TypeEtablissementModel modifier(TypeEtablissementModel r, Long id) {
		return service.modifier(r, id);
	}

	@Override
	public TypeEtablissementModel getParId(Long id) {
		return service.getParId(id);
	}

	@Override
	public List<TypeEtablissementModel> getliste() {
		return service.getliste();
	}

	@Override
	public void supprimer(Long id) {
		service.supprimer(id);
	}
}
