package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.EtablissementBusinessService;
import com.abouna.zekouli_bo.data.models.EtablissementModel;

@RestController
@RequestMapping("/etablissements")
public class EtablissementRestController implements AbstractRestController<EtablissementModel, Long>{
	@Autowired
	private EtablissementBusinessService service;

	@Override
	public EtablissementModel enregistrer(EtablissementModel r) {
		return service.enregistrer(r);
	}

	@Override
	public EtablissementModel modifier(EtablissementModel r, Long id) {
		return service.modifier(r, id);
	}

	@Override
	public EtablissementModel getParId(Long id) {
		return service.getParId(id);
	}

	@Override
	public List<EtablissementModel> getliste() {
		return service.getliste();
	}

	@Override
	public void supprimer(Long id) {
		service.supprimer(id);
	}
	
}
