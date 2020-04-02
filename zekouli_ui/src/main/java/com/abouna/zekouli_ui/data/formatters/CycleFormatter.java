package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.CycleModel;
import com.abouna.zekouli_ui.services.CycleService;

@Component
public class CycleFormatter implements Formatter<CycleModel>{
	@Autowired
	private CycleService service;

	@Override
	public String print(CycleModel object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public CycleModel parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
