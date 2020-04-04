package com.abouna.zekouli_ui.controllers.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_ui.data.dtos.SerieDto;
import com.abouna.zekouli_ui.services.SerieService;

@RestController
@RequestMapping("/ajax/series")
public class SerieAjaxController {
	@Autowired
	private SerieService serieService;
	
	
	@GetMapping("/etablissement/{id}")
	public List<SerieDto> getListeParEtablissement(@PathVariable Long id){
		return serieService.getListeParEtablissement(id);
	}
}
