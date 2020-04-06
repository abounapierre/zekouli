package com.abouna.zekouli_ui.controllers.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.services.ClasseService;

@RestController
@RequestMapping("/ajax/classes")
public class ClasseAjaxController {
	@Autowired
	private ClasseService classeService;
	
	@GetMapping("/etablissement/{id}")
	public List<ClasseDto> getListeClasseParEtablissement(@PathVariable("id") Long id){
		return classeService.getListeClasseParEtablissement(id);
	}
}
