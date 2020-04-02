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
import com.abouna.zekouli_ui.data.models.CycleModel;
import com.abouna.zekouli_ui.data.models.SerieModel;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.SerieService;

@Controller
@RequestMapping("/serie")
public class SerieController extends AbstractController{

	@Autowired
	private SerieService service;
	@Autowired
	private EtablissementService etService;

	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("series", service.getListe());
		model.addAttribute("serieModel", new CycleModel());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/serie";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("serieModel") @Valid SerieModel serieModel,
			BindingResult result, Model model) {
		if (!result.hasErrors() && serieModel.getCode() != null && serieModel.getLibelle() != null) {
			service.enregistrerOuModifier(serieModel);
			model.addAttribute("message", "success");
			model.addAttribute("serieModel", new SerieModel());
		}
		model.addAttribute("series", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/serie";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		SerieModel serieModel = service.obtenirParId(id);
		if (serieModel != null) {
			model.addAttribute("serieModel", serieModel);
		}
		model.addAttribute("series", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/serie";
	}

	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("series", service.getListe());
		model.addAttribute("serieModel", new SerieModel());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/serie";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("serieModel", new SerieModel());
		model.addAttribute("series", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/serie";
	}
}
