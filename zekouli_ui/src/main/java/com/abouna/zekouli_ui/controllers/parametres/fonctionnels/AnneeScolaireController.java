package com.abouna.zekouli_ui.controllers.parametres.fonctionnels;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.abouna.zekouli_ui.controllers.AbstractController;

@Controller
public class AnneeScolaireController extends AbstractController{

	@Override
	@GetMapping("/annee-scolaire")
	public String getTemplate(Model model) {
		return "parametre/annee-scolaire";
	}

}
