package com.abouna.zekouli_ui.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.NiveauDto;
import com.abouna.zekouli_ui.services.proxy.NiveauProxy;

@Component
public class NiveauService extends AbstractServiceImpl<NiveauDto, Long> {
	
	public NiveauService(NiveauProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	private final NiveauProxy proxy;

	public List<NiveauDto> getListeParEtablissement(Long id) {
		return proxy.getListeParEtablissement(id);
	}

	public List<NiveauDto> getListeParCycle(Long id) {
		return proxy.getListeParCycle(id);
	}

}
