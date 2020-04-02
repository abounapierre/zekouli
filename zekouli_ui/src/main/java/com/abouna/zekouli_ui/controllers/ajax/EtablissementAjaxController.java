package com.abouna.zekouli_ui.controllers.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_ui.data.models.EtablissementModel;
import com.abouna.zekouli_ui.services.EtablissementService;

@RestController
@RequestMapping("/ajax/etablissements")
public class EtablissementAjaxController {
	@Autowired
	private EtablissementService etablissementService;

	
	@GetMapping
	public List<EtablissementModel> getEtablissementList() {
		return etablissementService.getListe();
	}
}
