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
import com.abouna.zekouli_ui.data.dtos.NiveauDto;
import com.abouna.zekouli_ui.services.CycleService;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.NiveauService;

@Controller
@RequestMapping("/niveau")
public class NiveauController extends AbstractController<NiveauDto>{

	@Autowired
	private NiveauService service;
	@Autowired
	private EtablissementService etService;
	@Autowired
	private CycleService cycleService;

	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("niveaux", service.getListe());
		model.addAttribute("niveauModel", new NiveauDto());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/niveau";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("niveauModel") @Valid NiveauDto niveauModel,
			BindingResult result, Model model) {
		if (!result.hasErrors() && niveauModel.getCode() != null && niveauModel.getLibelle() != null) {
			service.enregistrerOuModifier(niveauModel,niveauModel.getId());
			model.addAttribute("message", "success");
			model.addAttribute("niveauModel", new NiveauDto());
		}
		model.addAttribute("niveaux", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/niveau";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		NiveauDto niveauModel = service.obtenirParId(id);
		if (niveauModel != null) {
			model.addAttribute("niveauModel", niveauModel);
			model.addAttribute("cycles", cycleService.getListeParEtablissement(niveauModel.getEtablissement().getId()));
		}
		model.addAttribute("niveaux", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/niveau";
	}

	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("niveaux", service.getListe());
		model.addAttribute("niveauModel", new NiveauDto());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/niveau";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("niveauModel", new NiveauDto());
		model.addAttribute("niveaux", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/niveau";
	}

	@Override
	protected boolean validerFormulaire(NiveauDto dto, Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
