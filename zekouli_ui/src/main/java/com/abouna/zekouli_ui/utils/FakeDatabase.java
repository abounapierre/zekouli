package com.abouna.zekouli_ui.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.models.EtablissementModel;
import com.abouna.zekouli_ui.data.models.TypeEtablissementModel;

@Component
public class FakeDatabase {
	private List<EtablissementModel> etablissements;
	private List<TypeEtablissementModel> typeEtablissements;

	public List<EtablissementModel> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(List<EtablissementModel> etablissements) {
		this.etablissements = etablissements;
	}

	public List<TypeEtablissementModel> getTypeEtablissements() {
		return typeEtablissements;
	}

	public void setTypeEtablissements(List<TypeEtablissementModel> typeEtablissements) {
		this.typeEtablissements = typeEtablissements;
	}

	@PostConstruct
	public void init() {		
		typeEtablissements = new ArrayList<>();
		typeEtablissements.add(new TypeEtablissementModel("Lycee d'enseignement general", 1));
		typeEtablissements.add(new TypeEtablissementModel("Lycee d'enseignement technique", 2));
		
		etablissements = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			etablissements.add(new EtablissementModel("CETIC DE YEMKOUT " + i, "CDY" + i,
					"cetic" + i + ".yemkout@gmail.com", "www.ceticdeyemkout" + i + ".cm", null, 237698984176L + i,
					"adresse " + i ,typeEtablissements.get(0)));
		}
	}

	public EtablissementModel findByCode(String code) {
		for(EtablissementModel model :etablissements) {
			if(code.equals(model.getCode())) {
				return model;
			}
		}
		return null;
	}
	
	public void modifier(EtablissementModel model) {
		boolean val = false;
		for(EtablissementModel e :etablissements) {
			if(model.getCode().equals(e.getCode())) {
				val = true;
				e.setAdresse(model.getAdresse());
				e.setCode(model.getCode());
				e.setEmail(model.getEmail());
				e.setLogo(model.getLogo());
				e.setNom(model.getNom());
				e.setSite(model.getSite());
				e.setTypeEtablissement(model.getTypeEtablissement());
				e.setTelephone(model.getTelephone());
			}
		}
		if(!val) {
			etablissements.add(model);
		}
	}

	public void supprimer(String code) {
		for(EtablissementModel e :etablissements) {
			if(e.getCode().contentEquals(code)) {
				etablissements.remove(e);
				return;
			}
		}
	}
	

}
