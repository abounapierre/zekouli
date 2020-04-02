package com.abouna.zekouli_ui.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.configs.BOConfig;
import com.abouna.zekouli_ui.configs.FeignConfig;
import com.abouna.zekouli_ui.data.models.SerieModel;
import com.abouna.zekouli_ui.services.proxy.SerieProxy;

@Component
public class SerieService extends AbstractService<SerieModel, Long> {
	@Autowired
	private BOConfig boConfig;
	private SerieProxy proxy = null;

	@PostConstruct
	public void init() {
		proxy = FeignConfig.getFeignClient(SerieProxy.class, boConfig.getUrlComplete().concat("series"));
	}

	@Override
	public SerieModel obtenirParId(Long id) {
		return proxy.getParId(id);
	}

	@Override
	public List<SerieModel> getListe() {
		return proxy.getList();
	}

	@Override
	public void supprimer(Long id) {
		proxy.supprimer(id);
	}

	@Override
	public SerieModel enregistrerOuModifier(SerieModel t) {
		if (t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t, t.getId());
	}

	public List<SerieModel> getListeParEtablissement(Long id) {
		return proxy.getListeParEtablissement(id);
	}

}
