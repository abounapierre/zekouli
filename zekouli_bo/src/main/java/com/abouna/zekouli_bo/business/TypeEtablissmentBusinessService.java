package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.TypeEtablissementModel;
import com.abouna.zekouli_bo.mappers.TypeEtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.TypeEtablissement;
import com.abouna.zekouli_bo.repositories.TypeEtablissementDao;

@Service
public class TypeEtablissmentBusinessService {
	@Autowired
	private TypeEtablissementDao typeEtablissementDao;
	private TypeEtablissementMapper mapper = Mappers.getMapper(TypeEtablissementMapper.class);

	public TypeEtablissementModel enregistrer(TypeEtablissementModel r) {
		TypeEtablissement e = mapper.destinationToSource(r);
		e.setDateCreation(LocalDateTime.now());
		e.setDateModification(LocalDateTime.now());
		e = typeEtablissementDao.save(e);
		return mapper.sourceToDestination(e);
	}

	public TypeEtablissementModel modifier(TypeEtablissementModel typeEtablissementModel, Long id) {
		Optional<TypeEtablissement> et = typeEtablissementDao.findById(id);
		TypeEtablissement e = mapper.destinationToSource(typeEtablissementModel);
		if (et.isPresent()) {
			e.setId(id);
			e = typeEtablissementDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}

	public TypeEtablissementModel getParId(Long id) {
		Optional<TypeEtablissement> typeEtablissment = typeEtablissementDao.findById(id);
		if (typeEtablissment.isPresent()) {
			return mapper.sourceToDestination(typeEtablissment.get());
		}
		return null;
	}

	public List<TypeEtablissementModel> getliste() {
		return mapper.toTypeEtablissementModelList(typeEtablissementDao.findAll());
	}

	public void supprimer(Long id) {
		typeEtablissementDao.deleteById(id);
	}

}
