package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.services.ClasseService;

@Component
public class ClasseFormatter implements Formatter<ClasseDto>{
	@Autowired
	private ClasseService service;

	@Override
	public String print(ClasseDto object, Locale locale) { 
		return object.getLibelle();
	}

	@Override
	public ClasseDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
