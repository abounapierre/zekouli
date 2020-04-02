package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.SerieBusinessService;
import com.abouna.zekouli_bo.data.models.SerieModel;

@RestController
@RequestMapping("/series")
public class SerieRestController implements AbstractRestController<SerieModel, Long> {
	@Autowired
	private SerieBusinessService service;

	@Override
	public SerieModel enregistrer(SerieModel r) {
		return service.enregistrer(r);
	}

	@Override
	public SerieModel modifier(SerieModel r, Long id) {
		return service.modifier(r, id);
	}

	@Override
	public SerieModel getParId(Long id) {
		return service.getParId(id);
	}

	@Override
	public List<SerieModel> getliste() {
		return service.getliste();
	}

	@Override
	public void supprimer(Long id) {
		service.supprimer(id);
	}
	
	@GetMapping("/etablissement/{id}")
	public List<SerieModel> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}
}
