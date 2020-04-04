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
import com.abouna.zekouli_ui.data.dtos.CycleDto;
import com.abouna.zekouli_ui.services.CycleService;
import com.abouna.zekouli_ui.services.EtablissementService;

@Controller
@RequestMapping("/cycle")
public class CycleController extends AbstractController<CycleDto> {
	@Autowired
	private CycleService service;
	@Autowired
	private EtablissementService etService;

	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("cycles", service.getListe());
		model.addAttribute("cycleModel", new CycleDto());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/cycle";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("cycleModel") @Valid CycleDto cycleModel,
			BindingResult result, Model model) {
		if (!result.hasErrors() && cycleModel.getCode() != null && cycleModel.getLibelle() != null) {
			service.enregistrerOuModifier(cycleModel,cycleModel.getId());
			model.addAttribute("message", "success");
			model.addAttribute("cycleModel", new CycleDto());
		}
		model.addAttribute("cycles", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/cycle";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		CycleDto cycleModel = service.obtenirParId(id);
		if (cycleModel != null) {
			model.addAttribute("cycleModel", cycleModel);
		}
		model.addAttribute("cycles", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/cycle";
	}

	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("cycles", service.getListe());
		model.addAttribute("cycleModel", new CycleDto());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/cycle";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("cycleModel", new CycleDto());
		model.addAttribute("cycles", service.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/cycle";
	}

	@Override
	protected boolean validerFormulaire(CycleDto dto, Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
