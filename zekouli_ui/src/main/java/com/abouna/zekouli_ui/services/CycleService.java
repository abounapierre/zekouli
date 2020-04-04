package com.abouna.zekouli_ui.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.CycleDto;
import com.abouna.zekouli_ui.services.proxy.CycleProxy;

@Component
public class CycleService extends AbstractServiceImpl<CycleDto, Long> {

	public CycleService(CycleProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	private final CycleProxy proxy;

	public List<CycleDto> getListeParEtablissement(Long id) {
		return proxy.getListeParEtablissement(id);
	}

}
