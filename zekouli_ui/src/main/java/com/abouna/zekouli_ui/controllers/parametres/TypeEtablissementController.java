package com.abouna.zekouli_ui.controllers.parametres;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abouna.zekouli_ui.controllers.AbstractController;
import com.abouna.zekouli_ui.data.models.TypeEtablissementModel;
import com.abouna.zekouli_ui.services.TypeEtablissementService;

@Controller
@RequestMapping("/type-etablissement")
public class TypeEtablissementController extends AbstractController{
	@Autowired
private TypeEtablissementService typeService;
	
	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("typeEtablissements", typeService.getListe());
		model.addAttribute("typeEtablissementModel", new TypeEtablissementModel());
		return "parametre/type-etablissment";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("typeEtablissementModel") @Valid TypeEtablissementModel typeEtablissementModel,
			BindingResult result, Model model) {
		if (!result.hasErrors() && typeEtablissementModel.getCode() != null && typeEtablissementModel.getLibelle() != null) {
			typeService.enregistrerOuModifier(typeEtablissementModel);
			model.addAttribute("message", "success");
			model.addAttribute("typeEtablissementModel", new TypeEtablissementModel());
		}
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/type-etablissment";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		TypeEtablissementModel typeEtablissementModel = typeService.obtenirParId(id);
		if (typeEtablissementModel != null) {
			model.addAttribute("typeEtablissementModel", typeEtablissementModel);
		}
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/type-etablissment";
	}

	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		typeService.supprimer(id);
		model.addAttribute("typeEtablissements", typeService.getListe());
		model.addAttribute("typeEtablissementModel", new TypeEtablissementModel());
		return "parametre/type-etablissment";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("typeEtablissementModel", new TypeEtablissementModel());
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/type-etablissment";
	}
	

}
