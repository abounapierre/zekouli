package com.abouna.zekouli_ui.controllers.parametres;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abouna.zekouli_ui.controllers.AbstractController;
import com.abouna.zekouli_ui.controllers.form.models.MessageForm;
import com.abouna.zekouli_ui.data.dtos.TypeEtablissementDto;
import com.abouna.zekouli_ui.services.TypeEtablissementService;

@Controller
@RequestMapping("/type-etablissement")
public class TypeEtablissementController extends AbstractController<TypeEtablissementDto>{
	@Autowired
	private TypeEtablissementService typeService;
	@Autowired
    private MessageSource messageSource;
	
	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("typeEtablissements", typeService.getListe());
		model.addAttribute("typeEtablissementModel", new TypeEtablissementDto());
		return "parametre/type-etablissment";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("typeEtablissementModel") @Valid TypeEtablissementDto typeEtablissementModel,
			BindingResult result, Model model) {
		if (validerFormulaire(typeEtablissementModel,model)) {
			typeService.enregistrerOuModifier(typeEtablissementModel,typeEtablissementModel.getId());
			model.addAttribute("typeEtablissementModel", new TypeEtablissementDto());
		}
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/type-etablissment";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		TypeEtablissementDto typeEtablissementModel = typeService.obtenirParId(id);
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
		model.addAttribute("typeEtablissementModel", new TypeEtablissementDto());
		return "parametre/type-etablissment";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("typeEtablissementModel", new TypeEtablissementDto());
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/type-etablissment";
	}
	
	protected boolean validerFormulaire(TypeEtablissementDto dto, Model model) {
		if(dto.getCode() == null || dto.getLibelle() == null || dto.getCode().isEmpty() || dto.getLibelle().isEmpty()) {
			model.addAttribute("messageModel",new MessageForm(messageSource.getMessage("application_parametre_type_etablissement_message_erreur", null, null), "error"));
			return false;
		}else {
			model.addAttribute("messageModel",new MessageForm(messageSource.getMessage("application_parametre_type_etablissement_message_ok", null, null), "success"));
			return true;
		}
	}

}
