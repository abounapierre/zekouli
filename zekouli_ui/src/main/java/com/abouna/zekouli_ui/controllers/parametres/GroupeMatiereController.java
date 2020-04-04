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
import com.abouna.zekouli_ui.controllers.form.models.MessageForm;
import com.abouna.zekouli_ui.data.dtos.GroupeMatiereDto;
import com.abouna.zekouli_ui.services.GroupeMatiereService;

@Controller
@RequestMapping("/groupe-matiere")
public class GroupeMatiereController extends AbstractPageController<GroupeMatiereDto, Long> {
	@Autowired
	private GroupeMatiereService groupeService;
	@Autowired
	private MessageSource source;

	@Override
	public String getTemplate(Model model) {
		model.addAttribute("groupeMatiereModel", new GroupeMatiereDto());
		model.addAttribute("groupeMatieres", groupeService.getListe());
		return "parametre/groupe-matiere";
	}

	@Override
	protected boolean validerFormulaire(GroupeMatiereDto dto, Model model) {
		if (dto.getCode() == null || dto.getCode().isEmpty() || dto.getLibelle() == null
				|| dto.getLibelle().isEmpty()) {
			model.addAttribute("messageModel", new MessageForm(
					source.getMessage("application_parametre_groupe_matiere_message_erreur", null, null), "error"));
			return false;
		}
		return true;
	}

	@Override
	public String enregistre(@ModelAttribute("groupeMatiereModel") GroupeMatiereDto dto, BindingResult result,
			Model model) {
		if (validerFormulaire(dto, model)) {
			if (groupeService.enregistrerOuModifier(dto, dto.getId()) != null) {
				model.addAttribute("messageModel", new MessageForm(
						source.getMessage("application_parametre_groupe_matiere_message_ok", null, null), "success"));
				model.addAttribute("groupeMatiereModel", new GroupeMatiereDto());
			} else {
				model.addAttribute("messageModel",
						new MessageForm(
								source.getMessage("application_parametre_groupe_matiere_message_erreur_1", null, null),
								"error"));
			}
		}
		model.addAttribute("groupeMatieres", groupeService.getListe());
		return "parametre/groupe-matiere";
	}

	@Override
	public String chargerFormulaire(@PathVariable("id") Long id, Model model) {
		GroupeMatiereDto dto = groupeService.obtenirParId(id);
		if(dto != null) {
			model.addAttribute("groupeMatiereModel", dto);
		}
		model.addAttribute("groupeMatieres", groupeService.getListe());
		return "parametre/groupe-matiere";
	}

	@Override
	public String supprimer(@PathVariable("id") Long id, Model model) {
		groupeService.supprimer(id);
		model.addAttribute("groupeMatiereModel", new GroupeMatiereDto());
		model.addAttribute("groupeMatieres", groupeService.getListe());
		return "parametre/groupe-matiere";
	}

	@Override
	public String initialiserFormulaire(Model model) {
		model.addAttribute("groupeMatiereModel", new GroupeMatiereDto());
		model.addAttribute("groupeMatieres", groupeService.getListe());
		return "parametre/groupe-matiere";
	}

}
