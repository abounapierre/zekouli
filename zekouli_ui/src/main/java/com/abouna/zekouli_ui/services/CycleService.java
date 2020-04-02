package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.CycleModel;
import com.abouna.zekouli_ui.services.proxy.CycleProxy;

@Component
public class CycleService extends AbstractService<CycleModel, Long> {

	private CycleProxy proxy;
	@Autowired
	private BOConfig boConfig;

	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(CycleProxy.class, boConfig.getUrlComplete().concat("cycles"));
	}

	@Override
	public CycleModel obtenirParId(Long id) {
		return proxy.getParId(id);
	}

	@Override
	public List<CycleModel> getListe() {
		return proxy.getList();
	}

	@Override
	public void supprimer(Long id) {
		proxy.supprimer(id);
	}

	@Override
	public CycleModel enregistrerOuModifier(CycleModel t) {
		if (t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t, t.getId());
	}

	public List<CycleModel> getListeParEtablissement(Long id) {
		return proxy.getListeParEtablissement(id);
	}

}
