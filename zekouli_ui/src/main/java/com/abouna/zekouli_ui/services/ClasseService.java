package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.ClasseModel;
import com.abouna.zekouli_ui.services.proxy.ClasseProxy;

@Component
public class ClasseService extends AbstractService<ClasseModel, Long>{
	@Autowired
	private BOConfig boConfig;

	private ClasseProxy proxy = null;

	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(ClasseProxy.class, boConfig.getUrlComplete().concat("classes"));
	}

	@Override
	public ClasseModel enregistrerOuModifier(ClasseModel t) {
		if(t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t);
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
}
