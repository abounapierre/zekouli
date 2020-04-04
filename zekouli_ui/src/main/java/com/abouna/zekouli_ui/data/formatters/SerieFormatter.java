package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.SerieDto;
import com.abouna.zekouli_ui.services.SerieService;

@Component
public class SerieFormatter implements Formatter<SerieDto>{
	@Autowired
	private SerieService service;

	@Override
	public String print(SerieDto object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public SerieDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
