package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.CycleDto;
import com.abouna.zekouli_ui.services.CycleService;

@Component
public class CycleFormatter implements Formatter<CycleDto>{
	@Autowired
	private CycleService service;

	@Override
	public String print(CycleDto object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public CycleDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
