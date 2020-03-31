package com.abouna.zekouli_ui.controllers.parametres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.abouna.zekouli_ui.controllers.AbstractController;

@Controller
public class SerieController extends AbstractController{

	@Override
	@GetMapping("/serie")
	public String getTemplate(Model model) {
		return "parametre/serie";
	}
}