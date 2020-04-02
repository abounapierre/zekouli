package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.NiveauModel;
import com.abouna.zekouli_ui.services.NiveauService;

@Component
public class NiveauFormatter implements Formatter<NiveauModel>{
	@Autowired
	private NiveauService niveauService;
	@Override
	public String print(NiveauModel object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public NiveauModel parse(String text, Locale locale) throws ParseException {
		return niveauService.obtenirParId(Long.valueOf(text));
	}

}
