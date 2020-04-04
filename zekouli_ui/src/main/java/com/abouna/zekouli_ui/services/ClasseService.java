package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.controllers.form.models.ClasseFormModel;
import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.services.proxy.ClasseProxy;

@Component
public class ClasseService extends AbstractServiceImpl<ClasseDto, Long> {
	
	public ClasseService(ClasseProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	private final ClasseProxy proxy;


	public ClasseFormModel enregistrerOuModifier(ClasseFormModel t) {
		ClasseFormModel form = new ClasseFormModel();
		ClasseDto model = null;
		if (t.getId() == null) {
			model = proxy.enregistrer((ClasseDto) t);
			form = (ClasseFormModel) t;
			form.setEtablissement(t.getNiveau().getEtablissement());
			return form;
		} else {
			model = proxy.modifier((ClasseDto) t, t.getId());
			if (model != null) {
				form = convertirEnClasseForm(model);
				form.setEtablissement(model.getNiveau().getEtablissement());
				return form;
			}
		}
		return null;
	}

	public ClasseFormModel convertirEnClasseForm(ClasseDto model) {
		if (model != null) {
			ClasseFormModel form = new ClasseFormModel();
			form.setCode(model.getCode());
			form.setCycle(model.getCycle());
			form.setDateCreation(model.getDateCreation());
			form.setDateModification(model.getDateModification());
			form.setEtablissement(model.getCycle().getEtablissement());
			form.setId(model.getId());
			form.setLibelle(model.getLibelle());
			form.setNiveau(model.getNiveau());
			form.setSerie(model.getSerie());
			form.setUtilisateur(model.getUtilisateur());
			return form;
		}
		return null;
	}

}
