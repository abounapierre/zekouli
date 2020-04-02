package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.SerieModel;
import com.abouna.zekouli_ui.services.SerieService;

@Component
public class SerieFormatter implements Formatter<SerieModel>{
	@Autowired
	private SerieService service;

	@Override
	public String print(SerieModel object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public SerieModel parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
