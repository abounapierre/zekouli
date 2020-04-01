package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.TypeEtablissementModel;
import com.abouna.zekouli_ui.services.TypeEtablissementService;

@Component
public class TypeEtablissementFormatter implements Formatter<TypeEtablissementModel>{
@Autowired
private TypeEtablissementService service;
	@Override
	public String print(TypeEtablissementModel object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public TypeEtablissementModel parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
