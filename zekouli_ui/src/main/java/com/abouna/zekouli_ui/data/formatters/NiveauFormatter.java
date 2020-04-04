package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.NiveauDto;
import com.abouna.zekouli_ui.services.NiveauService;

@Component
public class NiveauFormatter implements Formatter<NiveauDto>{
	@Autowired
	private NiveauService niveauService;
	@Override
	public String print(NiveauDto object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public NiveauDto parse(String text, Locale locale) throws ParseException {
		return niveauService.obtenirParId(Long.valueOf(text));
	}

}
