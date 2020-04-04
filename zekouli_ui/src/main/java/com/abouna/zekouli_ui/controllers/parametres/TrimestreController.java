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
import com.abouna.zekouli_ui.data.dtos.TrimestreDto;
import com.abouna.zekouli_ui.services.TrimestreService;

@Controller
@RequestMapping("/trimestre")
public class TrimestreController extends AbstractPageController<TrimestreDto, Long>{
	@Autowired
	private TrimestreService trimestreService;
	@Autowired
	private MessageSource messageSource;

	@Override
	public String getTemplate(Model model) {
		model.addAttribute("trimestreModel", new TrimestreDto());
		model.addAttribute("trimestres", trimestreService.getListe());
		return "parametre/trimestre";
	}

	@Override
	protected boolean validerFormulaire(TrimestreDto dto, Model model) {
		if(dto.getCode() == null || dto.getCode().isEmpty() || dto.getLibelle() == null || dto.getLibelle().isEmpty()) {
			model.addAttribute("messageModel", new MessageForm(messageSource.getMessage("application_parametre_trimestre_message_erreur", null, null), "error"));
			return false;
		}else {
			model.addAttribute("messageModel", new MessageForm(messageSource.getMessage("application_parametre_trimestre_message_ok", null, null), "success"));
			return true;
		}	
	}

	@Override
	public String enregistre(@ModelAttribute("trimestreModel") TrimestreDto dto, BindingResult result, Model model) {
		if (validerFormulaire(dto, model)) {
			trimestreService.enregistrerOuModifier(dto,dto.getId());
			model.addAttribute("trimestreModel", new TrimestreDto());
		}
		model.addAttribute("trimestres", trimestreService.getListe());
		return "parametre/trimestre";
	}

	@Override
	public String chargerFormulaire(@PathVariable("id") Long id, Model model) {
		TrimestreDto dto = trimestreService.obtenirParId(id);
		if (dto != null) {
			model.addAttribute("trimestreModel", dto);
		}
		model.addAttribute("trimestres", trimestreService.getListe());
		return "parametre/trimestre";
	}

	@Override
	public String supprimer(@PathVariable("id") Long id, Model model) {
		trimestreService.supprimer(id);
		model.addAttribute("messageModel", new MessageForm(messageSource.getMessage("application_parametre_trimestre_message_supprimer_ok", null, null), "success"));
		model.addAttribute("trimestreModel", new TrimestreDto());
		model.addAttribute("trimestres", trimestreService.getListe());
		return "parametre/trimestre";
	}

	@Override
	public String initialiserFormulaire(Model model) {
		model.addAttribute("trimestreModel", new TrimestreDto());
		model.addAttribute("trimestres", trimestreService.getListe());
		return "parametre/trimestre";
	}

}
