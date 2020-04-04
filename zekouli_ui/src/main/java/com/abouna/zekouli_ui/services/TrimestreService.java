package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.TrimestreDto;
import com.abouna.zekouli_ui.services.proxy.TrimestreProxy;

@Component
public class TrimestreService extends AbstractServiceImpl<TrimestreDto, Long>{

	public TrimestreService(TrimestreProxy proxy) {
		super(proxy);
	}

}
