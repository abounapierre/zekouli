package com.abouna.zekouli_ui.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import com.abouna.zekouli_ui.controllers.form.models.SexeModel;

@Configuration
public class UIUtils {
	@Autowired
    private MessageSource messageSource;
	
	public List<String> getStatus(){
		List<String> list = new ArrayList<>();
		list.add(messageSource.getMessage("application_status_nouveau_libelle", null, null));
		list.add(messageSource.getMessage("application_status_ancien_libelle", null, null));
		return list;
	}
	
	public List<String> getRegions(){
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(messageSource.getMessage("application_region_libelle_liste", null, null).split(",")));
		return list;
	}	
	
	public List<String> getSexes(){
		List<String> list = new ArrayList<>();
		list.add(messageSource.getMessage("application_sexe_libelle_masculin", null, null));
		list.add(messageSource.getMessage("application_sexe_libelle_feminin", null, null));
		return list;
	}	
}
