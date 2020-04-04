package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.MatiereDto;
import com.abouna.zekouli_ui.services.MatiereService;

@Component
public class MatiereFormatter implements Formatter<MatiereDto>{
	@Autowired
	private MatiereService service;

	@Override
	public String print(MatiereDto object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public MatiereDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}
}
