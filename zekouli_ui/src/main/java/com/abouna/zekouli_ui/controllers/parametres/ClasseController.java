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
import com.abouna.zekouli_ui.controllers.form.models.ClasseFormModel;
import com.abouna.zekouli_ui.controllers.form.models.MessageForm;
import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.services.ClasseService;
import com.abouna.zekouli_ui.services.CycleService;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.NiveauService;
import com.abouna.zekouli_ui.services.SerieService;

@Controller
@RequestMapping("/classe")
public class ClasseController extends AbstractController<ClasseFormModel>{
	
	@Autowired
	private EtablissementService etService;
	@Autowired
	private CycleService cycleService;
	@Autowired
	private NiveauService niveauService;
	@Autowired
	private SerieService serieService;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private MessageSource messageSource;

	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("classeModel", new ClasseFormModel());
		model.addAttribute("etablissements", etService.getListe());
		model.addAttribute("classes", classeService.getListe());
		return "parametre/classe";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("classeModel") @Valid ClasseFormModel classeModel,
			BindingResult result, Model model) {
		if (validerFormulaire(classeModel, model)) {
			classeService.enregistrerOuModifier(classeModel);
			model.addAttribute("classeModel", new ClasseFormModel());
		}
		model.addAttribute("classes", classeService.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		ClasseDto classeModel = classeService.obtenirParId(id);		
		if (classeModel != null) {
			ClasseFormModel form = classeService.convertirEnClasseForm(classeModel);
			model.addAttribute("classeModel", form);
			model.addAttribute("cycles", cycleService.getListeParEtablissement(form.getEtablissement().getId()));
			model.addAttribute("niveaux", niveauService.getListeParEtablissement(form.getEtablissement().getId()));
			model.addAttribute("series", serieService.getListeParEtablissement(form.getEtablissement().getId()));
		}
		model.addAttribute("classes", classeService.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}

	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") Long id, Model model) {
		classeService.supprimer(id);
		model.addAttribute("classes", classeService.getListe());
		model.addAttribute("classeModel", new ClasseFormModel());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("classeModel", new ClasseFormModel());
		model.addAttribute("classes", classeService.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}

	@Override
	protected boolean validerFormulaire(ClasseFormModel dto, Model model) {
		if(dto.getCode()==null || dto.getCode().isEmpty() || dto.getNiveau()==null || dto.getLibelle() == null || dto.getLibelle().isEmpty()
				|| dto.getCycle() == null) {
			model.addAttribute("messageModel", new MessageForm(messageSource.getMessage("application_parametre_classe_message_erreur", null, null), "error"));
			return false;
		}else {
			model.addAttribute("messageModel", new MessageForm(messageSource.getMessage("application_parametre_classe_message_ok", null, null), "success"));
			return true;
		}	
	}
	
	

}
