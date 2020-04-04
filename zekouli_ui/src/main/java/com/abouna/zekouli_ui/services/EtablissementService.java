package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.EtablissementDto;
import com.abouna.zekouli_ui.services.proxy.EtablissementProxy;

@Component
public class EtablissementService extends AbstractServiceImpl<EtablissementDto, Long> {

	public EtablissementService(EtablissementProxy proxy) {
		super(proxy);
	}

}
