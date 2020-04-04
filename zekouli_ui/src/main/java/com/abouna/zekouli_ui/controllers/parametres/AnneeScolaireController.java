package com.abouna.zekouli_ui.controllers.parametres;

import java.time.LocalDate;

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
import com.abouna.zekouli_ui.data.dtos.AnneeScolaireDto;
import com.abouna.zekouli_ui.services.AnneeScolaireService;

@Controller
@RequestMapping("/annee-scolaire")
public class AnneeScolaireController extends AbstractController<AnneeScolaireDto> {
	@Autowired
	private AnneeScolaireService service;
	@Autowired
    private MessageSource messageSource;

	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("anneeScolaires", service.getListe());
		model.addAttribute("anneeScolaireModel", new AnneeScolaireDto());
		return "parametre/annee-scolaire";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("anneeScolaireModel") @Valid AnneeScolaireDto anneeScolaireModel,
			BindingResult result, Model model) {
		if (validerFormulaire(anneeScolaireModel, model)) {
			service.enregistrerAnnee(anneeScolaireModel);
			model.addAttribute("anneeScolaireModel", new AnneeScolaireDto());
		}
		model.addAttribute("anneeScolaires", service.getListe());
		return "parametre/annee-scolaire";
	}
/**
 * 
 * @param id
 * @param model
 * @return
 */
	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		AnneeScolaireDto anneeScolaireDto = service.obtenirParId(id);
		if (anneeScolaireDto != null) {
			model.addAttribute("anneeScolaireModel", anneeScolaireDto);
		}
		model.addAttribute("anneeScolaires", service.getListe());
		return "parametre/annee-scolaire";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("anneeScolaires", service.getListe());
		model.addAttribute("anneeScolaireModel", new AnneeScolaireDto());
		return "parametre/annee-scolaire";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("anneeScolaireModel", new AnneeScolaireDto());
		model.addAttribute("anneeScolaires", service.getListe());
		return "parametre/annee-scolaire";
	}
	
	/**
	 * valider le formulaire.
	 * 
	 * @param anneeScolaireModel
	 * @param model
	 * @return
	 */
	protected boolean validerFormulaire(AnneeScolaireDto anneeScolaireModel, Model model) {
		LocalDate debut = anneeScolaireModel.getJourDebut();
		LocalDate fin = anneeScolaireModel.getJourFin();
		if(debut == null || fin == null) {
			model.addAttribute("messageModel",new MessageForm(messageSource.getMessage("application_parametre_annee_scolaire_message_erreur_1", null, null), "error"));
			return false;
		}else if (debut.isAfter(fin)) {
			model.addAttribute("messageModel",new MessageForm(messageSource.getMessage("application_parametre_annee_scolaire_message_erreur_2", null, null), "error"));
			return false;
		}else {
			model.addAttribute("messageModel",new MessageForm(messageSource.getMessage("application_parametre_annee_scolaire_message_ok", null, null), "success"));
			return true;
		}
		
	}

}
