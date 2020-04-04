package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.TrimestreDto;
import com.abouna.zekouli_ui.services.TrimestreService;

@Component
public class TrimestreFormatter implements Formatter<TrimestreDto>{
	@Autowired
	private TrimestreService service;

	@Override
	public String print(TrimestreDto object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public TrimestreDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
