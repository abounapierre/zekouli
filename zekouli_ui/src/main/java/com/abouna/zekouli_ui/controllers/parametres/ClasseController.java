package com.abouna.zekouli_ui.controllers.parametres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.abouna.zekouli_ui.controllers.AbstractController;
import com.abouna.zekouli_ui.data.models.ClasseModel;

@Controller
public class ClasseController extends AbstractController{
	

	@Override
	@GetMapping("/classe")
	public String getTemplate(Model model) {
		model.addAttribute("classeModel", new ClasseModel());
		return "parametre/classe";
	}

}
