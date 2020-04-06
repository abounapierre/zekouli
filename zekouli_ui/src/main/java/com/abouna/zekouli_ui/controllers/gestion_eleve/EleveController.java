package com.abouna.zekouli_ui.controllers.gestion_eleve;

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

import com.abouna.zekouli_ui.controllers.AbstractPageController;
import com.abouna.zekouli_ui.controllers.form.models.EleveFormModel;
import com.abouna.zekouli_ui.controllers.form.models.InscriptionFormModel;
import com.abouna.zekouli_ui.controllers.form.models.MessageForm;
import com.abouna.zekouli_ui.controllers.form.models.RechercheModel;
import com.abouna.zekouli_ui.data.dtos.EleveDto;
import com.abouna.zekouli_ui.data.dtos.InscriptionDto;
import com.abouna.zekouli_ui.services.EleveService;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.InscriptionService;
import com.abouna.zekouli_ui.utils.UIUtils;

@Controller
@RequestMapping("/eleve")
public class EleveController extends AbstractPageController<EleveFormModel, Long> {
	@Autowired
	private EleveService service;
	@Autowired
	private UIUtils utils;
	@Autowired
	private MessageSource source;
	@Autowired
	private EtablissementService etService;
	@Autowired
	private InscriptionService inscriptionService;

	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("eleveModel", new EleveFormModel());
		model.addAttribute("eleves", service.getListe());
		model.addAttribute("active", "1");
		model.addAttribute("readOnly", "true");
		model.addAttribute("inscriptionModel", new InscriptionFormModel());
		model.addAttribute("rechercheModel", new RechercheModel());
		chargerDonnees(model);
		model.addAttribute("eleve", new EleveDto());
		return "eleve/eleve";
	}

	@Override
	protected boolean validerFormulaire(EleveFormModel dto, Model model) {
		if (dto.getNom() == null || dto.getNom().isEmpty() || dto.getDateDeNaissance() == null
				|| dto.getLieuNaissance() == null || dto.getLieuNaissance().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public String enregistre(@ModelAttribute("eleveModel") EleveFormModel dto, BindingResult result, Model model) {
		if (validerFormulaire(dto, model)) {
			if (service.enregistrer(dto, dto.getId()) != null) {
				model.addAttribute("eleveModel", new EleveFormModel());
				model.addAttribute("inscriptionModel", new InscriptionFormModel());
				model.addAttribute("active", "1");
				model.addAttribute("messageModel", new MessageForm(
						source.getMessage("application_parametre_eleve_message_ok", null, null), "success"));
			} else {
				model.addAttribute("active", "2");
				model.addAttribute("messageModel", new MessageForm(
						source.getMessage("application_parametre_eleve_message_erreur", null, null), "error"));
			}
		} else {
			model.addAttribute("active", "2");
			model.addAttribute("messageModel", new MessageForm(
					source.getMessage("application_parametre_eleve_message_erreur", null, null), "error"));
		}
		model.addAttribute("eleves", service.getListe());
		model.addAttribute("rechercheModel", new RechercheModel());
		chargerDonnees(model);
		model.addAttribute("eleve", new EleveDto());
		return "eleve/eleve";
	}

	@Override
	public String chargerFormulaire(@PathVariable("id") Long id, Model model) {
		EleveDto dto = service.obtenirParId(id);
		if (dto != null) {
			model.addAttribute("eleveModel", service.mapperFormulaire(dto));
			model.addAttribute("active", "2");
			model.addAttribute("readOnly", dto.isNouveau() == true ? "true" : "false");
		}
		model.addAttribute("inscriptionModel", new InscriptionFormModel());
		model.addAttribute("eleves", service.getListe());
		model.addAttribute("rechercheModel", new RechercheModel());
		model.addAttribute("eleve", new EleveDto());
		chargerDonnees(model);
		return "eleve/eleve";
	}

	@Override
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("eleveModel", new EleveFormModel());
		model.addAttribute("eleves", service.getListe());
		model.addAttribute("active", "1");
		model.addAttribute("readOnly", "true");
		model.addAttribute("inscriptionModel", new InscriptionFormModel());
		model.addAttribute("rechercheModel", new RechercheModel());
		model.addAttribute("eleve", new EleveDto());
		chargerDonnees(model);
		return "eleve/eleve";
	}

	@Override
	public String initialiserFormulaire(Model model) {
		model.addAttribute("eleveModel", new EleveFormModel());
		model.addAttribute("eleves", service.getListe());
		model.addAttribute("active", "1");
		model.addAttribute("readOnly", "true");
		model.addAttribute("inscriptionModel", new InscriptionFormModel());
		model.addAttribute("rechercheModel", new RechercheModel());
		model.addAttribute("eleve", new EleveDto());
		chargerDonnees(model);
		return "eleve/eleve";
	}
	
	@PostMapping("/rechercher")
	public String rechercher(@ModelAttribute("rechercheModel") RechercheModel rechercheModel, Model model) {
		if(!rechercheModel.getMatricule().isEmpty() || !rechercheModel.getNom().isEmpty()) {
			model.addAttribute("eleves", service.getListeParMatriculeOuNom(rechercheModel.getMatricule(),rechercheModel.getNom()));
		}
		model.addAttribute("active", "1");
		model.addAttribute("readOnly", "true");
		model.addAttribute("inscriptionModel", new InscriptionFormModel());
		model.addAttribute("eleveModel", new EleveFormModel());
		model.addAttribute("eleve", new EleveDto());
		chargerDonnees(model);
		//model.addAttribute("rechercheModel", new RechercheModel());
		return "eleve/eleve";
	}
	
	@PostMapping("/enregistrer-formulaire-inscription")
	public String enregistrerInscription(@ModelAttribute("inscriptionFormModel") InscriptionFormModel inscriptionFormModel, Model model) {
		if(validerFormulaireInscription(model, inscriptionFormModel)) {
			EleveDto eleveDto = service.obtenirParId(inscriptionFormModel.getIdEleve());			
			model.addAttribute("eleve", eleveDto);
			MessageForm message = inscriptionService.enregistrerFormulaire(inscriptionFormModel, eleveDto);
			model.addAttribute("messageModel",message);
			model.addAttribute("inscriptionModel", inscriptionFormModel);
		}else {
			model.addAttribute("inscriptionModel", new InscriptionFormModel());
			model.addAttribute("eleve", new EleveDto());
		}		
		model.addAttribute("active", "3");
		model.addAttribute("readOnly", "true");
		model.addAttribute("eleveModel", new EleveFormModel());
		model.addAttribute("rechercheModel", new RechercheModel());
		model.addAttribute("etablissements", etService.getListe());
		model.addAttribute("eleves", service.getListe());
		chargerDonnees(model);
		return "eleve/eleve";
	}
	
	@GetMapping("/formulaire-inscription/{id}")
	public String mapperFormulaireInscription(@PathVariable("id") Long id, Model model) {
		EleveDto eleveDto = service.obtenirParId(id);
		InscriptionFormModel ins = new InscriptionFormModel();
		ins.setIdEleve(eleveDto.getId());
		model.addAttribute("eleve", eleveDto);
		model.addAttribute("active", "3");
		model.addAttribute("readOnly", "true");
		model.addAttribute("inscriptionModel", ins);
		model.addAttribute("eleveModel", new EleveFormModel());
		model.addAttribute("rechercheModel", new RechercheModel());
		model.addAttribute("etablissements", etService.getListe());
		model.addAttribute("eleves", service.getListe());
		chargerDonnees(model);
		return "eleve/eleve";
	}
	
	private boolean validerFormulaireInscription(Model model,InscriptionFormModel inscriptionFormModel) {
		if(inscriptionFormModel.getIdEleve() == null || inscriptionFormModel.getClasse() == null) {
			model.addAttribute("messageModel", new MessageForm(
					source.getMessage("application_parametre_inscription_eleve_message_erreur",
							null , null), "error"));
			return false;
		}
		return true;
	}
	
	private void chargerDonnees(Model model) {
		model.addAttribute("statuss", utils.getStatus());
		model.addAttribute("regions", utils.getRegions());
		model.addAttribute("sexes", utils.getSexes());
	}
}
