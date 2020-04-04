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
import com.abouna.zekouli_ui.data.dtos.SequenceDto;
import com.abouna.zekouli_ui.services.SequenceService;
import com.abouna.zekouli_ui.services.TrimestreService;

@Controller
@RequestMapping("/sequence")
public class SequenceController extends AbstractPageController<SequenceDto, Long>{
	@Autowired
	private SequenceService service;
	@Autowired
	private MessageSource source;
	@Autowired
	private TrimestreService tService;

	@Override
	public String getTemplate(Model model) {
		model.addAttribute("sequenceModel", new SequenceDto());
		model.addAttribute("sequences", service.getListe());
		model.addAttribute("trimestres", tService.getListe());
		return "parametre/sequence";
	}

	@Override
	protected boolean validerFormulaire(SequenceDto dto, Model model) {
		if(dto.getCode() == null || dto.getCode().isEmpty() || dto.getLibelle() == null || dto.getLibelle().isEmpty() || dto.getTrimestre() == null) {
			model.addAttribute("messageModel", new MessageForm(source.getMessage("application_parametre_sequence_message_erreur", null, null), "error"));
			return false;
		}
		return true;
	}

	@Override
	public String enregistre(@ModelAttribute("sequenceModel")  SequenceDto dto, BindingResult result, Model model) {
		if(validerFormulaire(dto, model)) {
			if(service.enregistrerOuModifier(dto, dto.getId())!=null) {
				model.addAttribute("messageModel", new MessageForm(source.getMessage("application_parametre_sequence_message_ok", null, null), "success"));
				model.addAttribute("sequenceModel", new SequenceDto());
			}else {
				model.addAttribute("messageModel", new MessageForm(source.getMessage("application_parametre_sequence_message_erreur_1", null, null), "error"));
			}
		}
		model.addAttribute("sequences", service.getListe());
		model.addAttribute("trimestres", tService.getListe());
		return "parametre/sequence";
	}

	@Override
	public String chargerFormulaire(@PathVariable("id") Long id, Model model) {
		SequenceDto dto = service.obtenirParId(id);
		if(dto != null) {
			model.addAttribute("sequenceModel",dto);
		}
		model.addAttribute("sequenceModel", new SequenceDto());
		model.addAttribute("sequences", service.getListe());
		model.addAttribute("trimestres", tService.getListe());
		return "parametre/sequence";
	}

	@Override
	public String supprimer(@PathVariable("id") Long id, Model model) {
		service.supprimer(id);
		model.addAttribute("sequences", service.getListe());
		model.addAttribute("trimestres", tService.getListe());
		return "parametre/sequence";
	}

	@Override
	public String initialiserFormulaire(Model model) {
		model.addAttribute("sequenceModel", new SequenceDto());
		model.addAttribute("sequences", service.getListe());
		model.addAttribute("trimestres", tService.getListe());
		return "parametre/sequence";
	}

}
