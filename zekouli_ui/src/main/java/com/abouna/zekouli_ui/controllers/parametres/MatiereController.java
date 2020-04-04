package com.abouna.zekouli_ui.controllers.parametres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abouna.zekouli_ui.controllers.AbstractPageController;
import com.abouna.zekouli_ui.controllers.form.models.MatiereFormModel;
import com.abouna.zekouli_ui.controllers.form.models.MessageForm;
import com.abouna.zekouli_ui.data.dtos.MatiereDto;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.GroupeMatiereService;
import com.abouna.zekouli_ui.services.MatiereService;
import com.abouna.zekouli_ui.services.NiveauService;
import com.abouna.zekouli_ui.services.SerieService;

@Controller
@RequestMapping("/matiere")
public class MatiereController extends AbstractPageController<MatiereFormModel, Long>{
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private GroupeMatiereService gService;
	@Autowired
	private NiveauService niveauService;
	@Autowired
	private SerieService serieService;
	@Autowired
	private EtablissementService etService;
	@Autowired
	private MessageSource messageResource;

	@Override
	public String getTemplate(Model model) {
		model.addAttribute("matiereModel", new MatiereFormModel());
		chargerDonnees(model);
		return "parametre/matiere";
	}

	@Override
	protected boolean validerFormulaire(MatiereFormModel dto, Model model) {
		if(dto.getCode() == null || dto.getLibelle() == null || dto.getCode().isEmpty() || dto.getLibelle().isEmpty()) {
			model.addAttribute("messageModel", new MessageForm(messageResource.getMessage("application_parametre_matiere_message_erreur", null, null), "error"));
			return false;
		}
		return true;
	}

	@Override
	public String enregistre(@ModelAttribute("matiereModel") MatiereFormModel dto, BindingResult result, Model model) {
		if(validerFormulaire(dto, model)) {
			if(matiereService.enregistrerFormulaire(dto, dto.getId())!=null) {
				model.addAttribute("messageModel", new MessageForm(messageResource.getMessage("application_parametre_matiere_message_ok", null, null), "success"));
				model.addAttribute("matiereModel", new MatiereFormModel());
			}else {
				model.addAttribute("messageModel", new MessageForm(messageResource.getMessage("application_parametre_matiere_message_erreur_1", null, null), "error"));
			}
		}
		chargerDonnees(model);
		return "parametre/matiere";
	}

	@Override
	public String chargerFormulaire(@PathVariable("id") Long id, Model model) {
		 MatiereDto dto = matiereService.obtenirParId(id);
		 if(dto!=null) {			 
			 model.addAttribute("series", serieService.getListeParEtablissement(dto.getNiveau().getEtablissement().getId()));
			 model.addAttribute("niveaux", niveauService.getListeParEtablissement(dto.getNiveau().getEtablissement().getId()));
			 model.addAttribute("matiereModel", matiereService.mapperFormulaire(dto));
		 }
		 chargerDonnees(model);
		return "parametre/matiere";
	}

	@Override
	public String supprimer(@PathVariable("id") Long id, Model model) {
		matiereService.supprimer(id);
		model.addAttribute("matiereModel", new MatiereFormModel());
		chargerDonnees(model);
		return "parametre/matiere";
	}

	@Override
	public String initialiserFormulaire(Model model) {
		model.addAttribute("matiereModel", new MatiereFormModel());
		chargerDonnees(model);
		return "parametre/matiere";
	}
	
	private void chargerDonnees(Model model) {
		model.addAttribute("matieres", matiereService.getListe());
		model.addAttribute("etablissements", etService.getListe());
		model.addAttribute("groupeMatieres", gService.getListe());
	}

}
