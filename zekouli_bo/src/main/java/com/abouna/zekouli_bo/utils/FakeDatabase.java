package com.abouna.zekouli_bo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_bo.data.models.EtablissementModel;
import com.abouna.zekouli_bo.data.models.TypeEtablissementModel;
import com.abouna.zekouli_bo.mappers.TypeEtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.TypeEtablissementDao;

@Component
public class FakeDatabase {
	@Autowired
	private TypeEtablissementDao typeEtablissementDao;
	@Autowired
	private EtablissementDao etablissementDao;
	private TypeEtablissementMapper mapper= Mappers.getMapper(TypeEtablissementMapper.class);
	private List<EtablissementModel> etablissements;
	private List<TypeEtablissementModel> typeEtablissements;
	@Autowired
	private CycleDao cycleDao;

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
		TypeEtablissementModel t = new TypeEtablissementModel("Lycee d'enseignement general","LYGEN");
		t.setDateCreation(LocalDateTime.now());
		t.setId(1L);
		t.setDateModification(LocalDateTime.now());
		typeEtablissementDao.save(mapper.destinationToSource(t));
		typeEtablissements.add(t);
		t = new TypeEtablissementModel("Lycee d'enseignement technique","LYTECH");
		t.setDateCreation(LocalDateTime.now());
		t.setId(2L);
		t.setDateModification(LocalDateTime.now());
		typeEtablissements.add(t);
		
		typeEtablissementDao.save(mapper.destinationToSource(t));
		
		etablissements = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			i++;
			EtablissementModel e = new EtablissementModel("CETIC DE YEMKOUT " + i, "CDY" + i,
					"cetic" + i + ".yemkout@gmail.com", "www.ceticdeyemkout" + i + ".cm", null, 237698984176L + i,
					"adresse " + i ,typeEtablissements.get(0));
			e.setId(Long.valueOf(i));
			etablissements.add(e);
		}
		/*Optional<Etablissement> e = etablissementDao.findById(3L);
		if(e.isPresent()) {
			etablissementDao.deleteById(e.get().getId());
		}
		
		Optional<Cycle> cy = cycleDao.findById(6L);
		if(cy.isPresent()) {
			cycleDao.deleteById(6L);
		}*/
	}

	public EtablissementModel findByIde(Long id) {
		for(EtablissementModel model :etablissements) {
			if(id.equals(model.getId())) {
				return model;
			}
		}
		return null;
	}
	
	public EtablissementModel findByCode(String code) {
		for(EtablissementModel model :etablissements) {
			if(code.equals(model.getCode())) {
				return model;
			}
		}
		return null;
	}
	
	public EtablissementModel modifier(EtablissementModel model) {
		boolean val = false; 
		for(EtablissementModel e :etablissements) {
			if(model.getCode().equals(e.getCode())) {
				val = true;
				e.setAdresse(model.getAdresse());
				e.setCode(model.getCode());
				e.setEmail(model.getEmail());
				e.setLogo(model.getLogo());
				e.setLibelle(model.getLibelle());
				e.setSite(model.getSite());
				e.setTypeEtablissement(model.getTypeEtablissement());
				e.setTelephone(model.getTelephone());
			}
		}
		if(!val) {
			etablissements.add(model);
		}
		return model;
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
