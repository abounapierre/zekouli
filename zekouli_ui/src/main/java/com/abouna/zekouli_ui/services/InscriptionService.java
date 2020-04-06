package com.abouna.zekouli_ui.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.controllers.form.models.InscriptionFormModel;
import com.abouna.zekouli_ui.controllers.form.models.InscriptionListeFormModel;
import com.abouna.zekouli_ui.controllers.form.models.MessageForm;
import com.abouna.zekouli_ui.data.dtos.AnneeScolaireDto;
import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.data.dtos.EleveDto;
import com.abouna.zekouli_ui.data.dtos.InscriptionDto;
import com.abouna.zekouli_ui.services.proxy.InscriptionProxy;

@Component
public class InscriptionService extends AbstractServiceImpl<InscriptionDto, Long> {
	@Autowired
	private AnneeScolaireService anneeScolaireService;
	@Autowired
	private MessageSource source;
	private final InscriptionProxy proxy;

	public InscriptionService(InscriptionProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	public InscriptionDto enregistrerFormulaire(InscriptionListeFormModel form) {
		for (EleveDto dto : form.getEleveInscrits()) {
			InscriptionDto inscriptionDto = new InscriptionDto();
		}
		return null;
	}

	public MessageForm enregistrerFormulaire(InscriptionFormModel model, EleveDto eleveDto) {
		InscriptionDto dto = new InscriptionDto();
		dto.setAnneeScolaire(anneeScolaireService.getAnneeScolaireEncours());
		dto.setEleve(eleveDto);
		dto.setClasse(model.getClasse());
		InscriptionDto ins = proxy.getInscriptionAnneeEleve(dto.getAnneeScolaire().getId(), eleveDto.getId());
		if (ins != null) {
			String[] params = new String[] {
					ins.getEleve().getNom() + " " + ins.getEleve().getPrenom() + " " + ins.getEleve().getMatricule(), ins.getClasse().getCode() };
			return new MessageForm(
					source.getMessage("application_parametre_inscription_eleve_message_ok_1", 
							params, LocaleContextHolder.getLocale()),
					"error");
		}
		if (enregistrerOuModifier(dto, dto.getId()) != null) {
			String[] params = new String[] {
					dto.getEleve().getNom() + " " + dto.getEleve().getPrenom() + " " + dto.getEleve().getMatricule() };
			return new MessageForm(
					source.getMessage("application_parametre_inscription_eleve_message_ok", params, null), "success");
		}
		return null;
	}

	public List<InscriptionDto> getListeParClasse(ClasseDto classeDto) {
		AnneeScolaireDto anneeDto = anneeScolaireService.getAnneeScolaireEncours();
		return proxy.getListeParClasse(classeDto.getId(), anneeDto.getId());
	}
}
