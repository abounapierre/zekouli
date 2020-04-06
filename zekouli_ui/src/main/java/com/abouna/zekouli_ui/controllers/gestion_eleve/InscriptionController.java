package com.abouna.zekouli_ui.controllers.gestion_eleve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abouna.zekouli_ui.controllers.form.models.InscriptionFormulaireRecherche;
import com.abouna.zekouli_ui.data.dtos.InscriptionDto;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.InscriptionService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {
	@Autowired
	private InscriptionService inscriptionService;
	@Autowired
	private EtablissementService etService;

	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("inscriptionFormulaireRechercheModel",new InscriptionFormulaireRecherche());
		model.addAttribute("etablissements", etService.getListe());
		return "eleve/inscription";
	}
	
	@PostMapping("/rechercher")
	public String rechercher(@ModelAttribute("inscriptionFormulaireRechercheModel") 
	InscriptionFormulaireRecherche inscriptionFormulaireRechercheModel, Model model) {
		if(inscriptionFormulaireRechercheModel.getClasse() != null) {
			model.addAttribute("inscriptions"
					,inscriptionService.getListeParClasse(inscriptionFormulaireRechercheModel.getClasse()));
		}
		model.addAttribute("inscriptionFormulaireRechercheModel", inscriptionFormulaireRechercheModel);
		model.addAttribute("etablissements", etService.getListe());
		return "eleve/inscription";
	}
	
	@RequestMapping(value = "/annuler/{id}", method = RequestMethod.GET)
	public String annulerIncription(@PathVariable("id") Long id,Model model) {
		if(id != null) {
			InscriptionDto inscriptionDto = inscriptionService.obtenirParId(id);
			inscriptionService.supprimer(id);
			model.addAttribute("inscriptions"
					,inscriptionService.getListeParClasse(inscriptionDto.getClasse()));
			InscriptionFormulaireRecherche inscriptionFormulaireRechercheModel = new InscriptionFormulaireRecherche();
			inscriptionFormulaireRechercheModel.setClasse(inscriptionDto.getClasse());
			model.addAttribute("inscriptionFormulaireRechercheModel", inscriptionFormulaireRechercheModel);
		}
		model.addAttribute("etablissements", etService.getListe());
		return "eleve/inscription";
	}
}
