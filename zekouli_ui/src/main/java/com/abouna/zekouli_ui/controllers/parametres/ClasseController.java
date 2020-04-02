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
import com.abouna.zekouli_ui.data.models.ClasseModel;
import com.abouna.zekouli_ui.services.ClasseService;
import com.abouna.zekouli_ui.services.CycleService;
import com.abouna.zekouli_ui.services.EtablissementService;
import com.abouna.zekouli_ui.services.NiveauService;
import com.abouna.zekouli_ui.services.SerieService;
import com.abouna.zekouli_ui.vue.dto.ClasseForm;

@Controller
@RequestMapping("/classe")
public class ClasseController extends AbstractController{
	
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

	@Override
	@GetMapping
	public String getTemplate(Model model) {
		model.addAttribute("classeModel", new ClasseForm());
		model.addAttribute("etablissements", etService.getListe());
		model.addAttribute("classes", classeService.getListe());
		return "parametre/classe";
	}

	@PostMapping("/enregister")
	public String enregistre(@ModelAttribute("classeModel") @Valid ClasseForm classeModel,
			BindingResult result, Model model) {
		if (!result.hasErrors() && classeModel.getCode() != null && classeModel.getLibelle() != null) {
			classeService.enregistrerOuModifier(classeModel);
			model.addAttribute("message", "success");
			model.addAttribute("classeModel", new ClasseForm());
		}
		model.addAttribute("classes", classeService.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		ClasseModel classeModel = classeService.obtenirParId(id);		
		if (classeModel != null) {
			ClasseForm form = classeService.convertirEnClasseForm(classeModel);
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
		model.addAttribute("classeModel", new ClasseForm());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}

	@GetMapping("/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("classeModel", new ClasseForm());
		model.addAttribute("classes", classeService.getListe());
		model.addAttribute("etablissements", etService.getListe());
		return "parametre/classe";
	}
	
	

}
