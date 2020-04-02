package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.ClasseBusinessService;
import com.abouna.zekouli_bo.data.models.ClasseModel;

@RestController
@RequestMapping("/classes")
public class ClasseRestController implements AbstractRestController<ClasseModel, Long>{
	@Autowired
	private ClasseBusinessService service;


	@Override
	public ClasseModel enregistrer(ClasseModel classeModel) {
		return service.enregistrer(classeModel);
	}

	@Override
	public ClasseModel modifier(ClasseModel classeModel, Long id) {		
		return service.modifier(classeModel, id);
	}

	@Override
	public ClasseModel getParId(Long id) {
		return service.getParId(id);
	}
	
	@Override
	public List<ClasseModel> getliste(){
		return service.getliste();
	}
	
	@Override
	public void supprimer(Long id) {
		service.supprimer(id);
	}
	
	@GetMapping("/cycle/{id}")
	public List<ClasseModel> getListeParCycle(@PathVariable Long id){
		return service.getListeParCycle(id);
	}
	
	@GetMapping("/serie/{id}")
	public List<ClasseModel> getListeParSerie(@PathVariable Long id){
		return service.getListeParSerie(id);
	}
	
	@GetMapping("/niveau/{id}")
	public List<ClasseModel> getListeParNiveau(@PathVariable Long id){
		return service.getListeParNiveau(id);
	}
	
	@GetMapping("/etablissement/{id}")
	public List<ClasseModel> getListeParEtablissement(@PathVariable Long id){
		return service.getListeParEtablissement(id);
	}

}
