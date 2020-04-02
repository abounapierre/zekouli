package com.abouna.zekouli_ui.controllers.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_ui.data.models.NiveauModel;
import com.abouna.zekouli_ui.services.NiveauService;

@RestController
@RequestMapping("/ajax/niveaux")
public class NiveauAjaxController {
	@Autowired
	private NiveauService niveauService;
	
	
	@GetMapping("/etablissement/{id}")
	public List<NiveauModel> getListeNiveauParEtablissement(@PathVariable Long id){
		return niveauService.getListeParEtablissement(id);
	}
	
	@GetMapping("/cycle/{id}")
	public List<NiveauModel> getListeNiveauParCycle(@PathVariable Long id){
		return niveauService.getListeParCycle(id);
	}
	
	
}
