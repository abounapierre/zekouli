package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.EleveDto;
import com.abouna.zekouli_ui.services.EleveService;

@Component
public class EleveFormatter implements Formatter<EleveDto>{
	@Autowired
	private EleveService service;

	@Override
	public String print(EleveDto object, Locale locale) {
		return object.getNom().concat(" ").concat(object.getPrenom().concat(" (").concat(object.getMatricule()).concat(")"));
	}

	@Override
	public EleveDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
