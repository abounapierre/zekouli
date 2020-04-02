package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.NiveauBusinessService;
import com.abouna.zekouli_bo.data.models.NiveauModel;

@RestController
@RequestMapping("/niveaux")
public class NiveauRestController implements AbstractRestController<NiveauModel, Long> {
	@Autowired
	private NiveauBusinessService service;

	@Override
	public NiveauModel enregistrer(NiveauModel r) {
		return service.enregistrer(r);
	}

	@Override
	public NiveauModel modifier(NiveauModel r, Long id) {
		return service.modifier(r, id);
	}

	@Override
	public NiveauModel getParId(Long id) {
		return service.getParId(id);
	}

	@Override
	public List<NiveauModel> getliste() {
		return service.getliste();
	}

	@Override
	public void supprimer(Long id) {
		service.supprimer(id);
	}
	
	@GetMapping("/etablissement/{id}")
	public List<NiveauModel> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}
	
	@GetMapping("/cycle/{id}")
	public List<NiveauModel> getListeParCycle(@PathVariable Long id){
		return service.getListeParCycle(id);
	}
	
}
