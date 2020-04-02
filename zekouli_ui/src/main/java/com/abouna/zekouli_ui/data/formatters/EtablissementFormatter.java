package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.EtablissementModel;
import com.abouna.zekouli_ui.services.EtablissementService;

@Component
public class EtablissementFormatter implements Formatter<EtablissementModel>{
	@Autowired
	private EtablissementService service;

	@Override
	public String print(EtablissementModel object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public EtablissementModel parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
