package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.controllers.form.models.MatiereFormModel;
import com.abouna.zekouli_ui.data.dtos.MatiereDto;
import com.abouna.zekouli_ui.services.proxy.MatiereProxy;

@Component
public class MatiereService extends AbstractServiceImpl<MatiereDto, Long>{

	public MatiereService(MatiereProxy proxy) {
		super(proxy);
	}
	
	public MatiereFormModel mapperFormulaire(MatiereDto dto) {
		MatiereFormModel model = null;
		if(dto != null) {
			model = new MatiereFormModel();
			model.setCode(dto.getCode());
			model.setEtablissement(dto.getNiveau().getEtablissement());
			model.setGroupeMatiere(dto.getGroupeMatiere());
			model.setId(dto.getId());
			model.setLibelle(dto.getLibelle());
			model.setNiveau(dto.getNiveau());
			model.setSerie(dto.getSerie());
			model.setUtilisateur(dto.getUtilisateur());
		}
		return model;
	}
	
	public MatiereFormModel enregistrerFormulaire(MatiereFormModel model,Long id) {
		return mapperFormulaire(enregistrerOuModifier((MatiereDto)model, id));
	}

}
