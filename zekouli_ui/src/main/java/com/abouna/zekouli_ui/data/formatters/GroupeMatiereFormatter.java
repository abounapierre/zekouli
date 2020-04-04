package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.GroupeMatiereDto;
import com.abouna.zekouli_ui.services.GroupeMatiereService;

@Component
public class GroupeMatiereFormatter implements Formatter<GroupeMatiereDto>{
	@Autowired
	private GroupeMatiereService service;

	@Override
	public String print(GroupeMatiereDto object, Locale locale) {
		return object.getLibelle();
	}

	@Override
	public GroupeMatiereDto parse(String text, Locale locale) throws ParseException {
		return service.obtenirParId(Long.valueOf(text));
	}

}
