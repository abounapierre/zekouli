package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.TypeEtablissementModel;
import com.abouna.zekouli_ui.services.proxy.TypeEtablissementProxy;

@Component
public class TypeEtablissementService extends AbstractService<TypeEtablissementModel, Long>{
	@Autowired
	private BOConfig boConfig;
	
	private TypeEtablissementProxy proxy = null;
	
	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(TypeEtablissementProxy.class, boConfig.getUrlComplete().concat("type-etablissements"));
	}

	@Override
	public TypeEtablissementModel enregistrerOuModifier(TypeEtablissementModel t) {
		if(t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t);
	}

	@Override
	public List<TypeEtablissementModel> getListe() {
		return proxy.getList();
	}

	@Override
	public TypeEtablissementModel obtenirParId(Long id) {
		return proxy.getParId(id);
	}

	@Override
	public void supprimer(Long id) {
	proxy.supprimer(id);
	}

}
