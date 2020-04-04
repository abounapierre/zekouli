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

import com.abouna.zekouli_ui.controllers.AbstractController;
import com.abouna.zekouli_ui.data.dtos.EtablissementDto;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.TypeEtablissementService;

@Controller
public class EtablissementController extends AbstractController<EtablissementDto> {
	@Autowired
	private EtablissementService service;
	@Autowired
	private TypeEtablissementService typeService;

	@Override
	@GetMapping("/etablissement")
	public String getTemplate(Model model) {
		model.addAttribute("etablissements", service.getListe());
		model.addAttribute("typeEtablissements", typeService.getListe());
		model.addAttribute("etablissementModel", new EtablissementDto());
		return "parametre/etablissement";
	}

	@PostMapping("/etablissement/enregister")
	public String enregistre(@ModelAttribute("etablissementModel") @Valid EtablissementDto etablissementModel,
			BindingResult result, Model model) {
		if (!result.hasErrors() && etablissementModel.getCode() != null && etablissementModel.getLibelle() != null
				&& etablissementModel.getTypeEtablissement() != null) {
			service.enregistrerOuModifier(etablissementModel,etablissementModel.getId());
			model.addAttribute("message", "success");
		}
		model.addAttribute("etablissementModel", new EtablissementDto());
		model.addAttribute("etablissements", service.getListe());
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/etablissement";
	}

	@GetMapping("/etablissement/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		EtablissementDto etablissementModel = service.obtenirParId(id);
		if (etablissementModel != null) {
			model.addAttribute("etablissementModel", etablissementModel);
		}
		model.addAttribute("etablissements", service.getListe());
		model.addAttribute("typeEtablissements", typeService.getListe());
		return "parametre/etablissement";
	}

	@GetMapping("/etablissement/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("etablissements", service.getListe());
		model.addAttribute("typeEtablissements", typeService.getListe());
		model.addAttribute("etablissementModel", new EtablissementDto());
		return "parametre/etablissement";
	}

	@GetMapping("/etablissement/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("etablissementModel", new EtablissementDto());
		model.addAttribute("typeEtablissements", typeService.getListe());
		model.addAttribute("etablissements", service.getListe());
		return "parametre/etablissement";
	}

	@Override
	protected boolean validerFormulaire(EtablissementDto dto, Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
