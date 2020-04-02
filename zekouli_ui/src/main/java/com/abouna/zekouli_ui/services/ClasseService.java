package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.ClasseModel;
import com.abouna.zekouli_ui.services.proxy.ClasseProxy;
import com.abouna.zekouli_ui.vue.dto.ClasseForm;

@Component
public class ClasseService extends AbstractService<ClasseModel, Long> {
	@Autowired
	private BOConfig boConfig;

	private ClasseProxy proxy = null;

	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(ClasseProxy.class, boConfig.getUrlComplete().concat("classes"));
	}

	@Override
	public ClasseModel enregistrerOuModifier(ClasseModel t) {
		if (t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t, t.getId());
	}

	@Override
	public List<ClasseModel> getListe() {
		return proxy.getList();
	}

	@Override
	public ClasseModel obtenirParId(Long id) {
		return proxy.getParId(id);
	}

	@Override
	public void supprimer(Long id) {
		proxy.supprimer(id);
	}

	public ClasseForm enregistrerOuModifier(ClasseForm t) {
		ClasseForm form = new ClasseForm();
		ClasseModel model = null;
		if (t.getId() == null) {
			model = proxy.enregistrer((ClasseModel) t);
			form = (ClasseForm) t;
			form.setEtablissement(t.getNiveau().getEtablissement());
			return form;
		} else {
			model = proxy.modifier((ClasseModel) t, t.getId());
			if (model != null) {
				form = convertirEnClasseForm(model);
				form.setEtablissement(model.getNiveau().getEtablissement());
				return form;
			}
		}
		return null;
	}

	public ClasseForm convertirEnClasseForm(ClasseModel model) {
		if (model != null) {
			ClasseForm form = new ClasseForm();
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
