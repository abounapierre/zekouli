package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.NiveauModel;
import com.abouna.zekouli_ui.services.proxy.NiveauProxy;

@Component
public class NiveauService extends AbstractService<NiveauModel, Long> {
	@Autowired
	private BOConfig boConfig;
	private NiveauProxy proxy = null;

	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(NiveauProxy.class, boConfig.getUrlComplete().concat("niveaux"));
	}

	@Override
	public NiveauModel obtenirParId(Long id) {
		return proxy.getParId(id);
	}

	@Override
	public List<NiveauModel> getListe() {
		return proxy.getList();
	}

	@Override
	public void supprimer(Long id) {
		proxy.supprimer(id);
	}

	@Override
	public NiveauModel enregistrerOuModifier(NiveauModel t) {
		if(t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t, t.getId());
	}

	public List<NiveauModel> getListeParEtablissement(Long id) {
		return proxy.getListeParEtablissement(id);
	}

	public List<NiveauModel> getListeParCycle(Long id) {
		return proxy.getListeParCycle(id);
	}

}
