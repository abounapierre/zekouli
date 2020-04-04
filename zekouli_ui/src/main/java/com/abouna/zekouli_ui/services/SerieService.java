package com.abouna.zekouli_ui.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.SerieDto;
import com.abouna.zekouli_ui.services.proxy.SerieProxy;

@Component
public class SerieService extends AbstractServiceImpl<SerieDto, Long> {

	public SerieService(SerieProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	private SerieProxy proxy;

	public List<SerieDto> getListeParEtablissement(Long id) {
		return proxy.getListeParEtablissement(id);
	}

}
