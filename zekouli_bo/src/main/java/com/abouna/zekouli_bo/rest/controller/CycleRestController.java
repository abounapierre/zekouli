package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.CycleBusinessService;
import com.abouna.zekouli_bo.data.models.CycleModel;

@RestController
@RequestMapping("/cycles")
public class CycleRestController implements AbstractRestController<CycleModel, Long> {
	@Autowired
	private CycleBusinessService service;

	@Override
	public CycleModel enregistrer(CycleModel cycleModel) {
		return service.enregistrer(cycleModel);
	}

	@Override
	public CycleModel modifier(CycleModel cycleModel, Long id) {
		return service.modifier(cycleModel, id);
	}

	@Override
	public CycleModel getParId(Long id) {
		return service.getParId(id);
	}

	@Override
	public List<CycleModel> getliste() {
		return service.getliste();
	}

	@Override
	public void supprimer(Long id) {
		service.supprimer(id);
	}
	
	@GetMapping("/etablissement/{id}")
	public List<CycleModel> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}

}
