package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.SequenceDto;
import com.abouna.zekouli_ui.services.proxy.SequenceProxy;

@Component
public class SequenceService extends AbstractServiceImpl<SequenceDto, Long>{

	public SequenceService(SequenceProxy proxy) {
		super(proxy);
	}

}
