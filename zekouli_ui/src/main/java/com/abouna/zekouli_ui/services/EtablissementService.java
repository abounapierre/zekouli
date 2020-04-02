package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.EtablissementModel;
import com.abouna.zekouli_ui.services.proxy.EtablissementProxy;

@Component
public class EtablissementService extends AbstractService<EtablissementModel, Long> {
	@Autowired
	private BOConfig boConfig;

	EtablissementProxy proxy = null;

	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(EtablissementProxy.class, boConfig.getUrlComplete().concat("etablissements"));
	}

	@Override
	public EtablissementModel enregistrerOuModifier(EtablissementModel t) {
		if (t.getId() != null) {
			return proxy.modifier(t,t.getId());
		}
		return proxy.enregistrer(t);
	}

	@Override
	public EtablissementModel obtenirParId(Long id) {
		return proxy.getParId(id);
	}

	@Override
	public void supprimer(Long id) {
		proxy.supprimer(id);
	}

	@Override
	public List<EtablissementModel> getListe() {
		return proxy.getList();
	}

}
