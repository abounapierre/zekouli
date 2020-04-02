package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.abouna.zekouli_bo.data.models.EtablissementModel;
import com.abouna.zekouli_bo.mappers.EtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.repositories.EtablissementDao;

@Service
public class EtablissementBusinessService {
	@Autowired
	private EtablissementDao etablissementDao;
	private EtablissementMapper mapper= Mappers.getMapper(EtablissementMapper.class);

	public EtablissementModel enregistrer(EtablissementModel etablissementModel) {	
		Etablissement e = mapper.destinationToSource(etablissementModel);
		e.setDateCreation(LocalDateTime.now());
		e.setDateModification(LocalDateTime.now());
		e = etablissementDao.save(e);
		return mapper.sourceToDestination(e);
	}

	public EtablissementModel modifier(EtablissementModel etablissementModel, Long id) {
		Optional<Etablissement> et = etablissementDao.findById(id);
		Etablissement e = mapper.destinationToSource(etablissementModel);
		if(et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = etablissementDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}
	
	public EtablissementModel getParId(@PathVariable Long id) {
		Optional<Etablissement> e = etablissementDao.findById(id);
		return e.isPresent() == true ? mapper.sourceToDestination(e.get()) : null;
	}
	
	public List<EtablissementModel> getliste(){
		return mapper.toEtablissementModel(etablissementDao.findAll());
	}
	
	public void supprimer(@PathVariable Long id) {
		etablissementDao.deleteById(id);
	}
}
