package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.TypeEtablissementDto;
import com.abouna.zekouli_ui.services.proxy.TypeEtablissementProxy;

@Component
public class TypeEtablissementService extends AbstractServiceImpl<TypeEtablissementDto, Long> {

	public TypeEtablissementService(TypeEtablissementProxy proxy) {
		super(proxy);
	}

}
