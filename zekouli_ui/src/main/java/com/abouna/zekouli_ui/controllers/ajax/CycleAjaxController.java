package com.abouna.zekouli_ui.controllers.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_ui.data.dtos.CycleDto;
import com.abouna.zekouli_ui.services.CycleService;

@RestController
@RequestMapping("/ajax/cycles")
public class CycleAjaxController {
	@Autowired
	private CycleService cycleService;
	
	@GetMapping("/etablissement/{id}")
	public List<CycleDto> getListeCycleParEtablissement(@PathVariable Long id){
		return cycleService.getListeParEtablissement(id);
	}
}
