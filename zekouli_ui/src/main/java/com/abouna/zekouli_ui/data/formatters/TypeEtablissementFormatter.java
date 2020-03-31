package com.abouna.zekouli_ui.data.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.TypeEtablissementModel;
import com.abouna.zekouli_ui.utils.FakeDatabase;

@Component
public class TypeEtablissementFormatter implements Formatter<TypeEtablissementModel>{
@Autowired
private FakeDatabase fakeDatabase;
	@Override
	public String print(TypeEtablissementModel object, Locale locale) {
		return object.getNom();
	}

	@Override
	public TypeEtablissementModel parse(String text, Locale locale) throws ParseException {
		for(TypeEtablissementModel model : fakeDatabase.getTypeEtablissements()) {
			if(model.getId().equals(Integer.valueOf(text))) {
				return model;
			}
		}
		return null;
	}

}
