package com.abouna.zekouli_ui.controllers.gestion_eleve;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eleve")
public class EleveController {
	
	@GetMapping
	public String getTemplate(Model model) {
		return "eleve/eleve";
	}
}
