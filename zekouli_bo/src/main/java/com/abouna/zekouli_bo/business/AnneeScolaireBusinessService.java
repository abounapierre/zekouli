package com.abouna.zekouli_bo.business;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.dtos.AnneeScolaireDto;
import com.abouna.zekouli_bo.mappers.AnneeScolaireMapper;
import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;
import com.abouna.zekouli_bo.repositories.AnneeScolaireDao;

@Service
public class AnneeScolaireBusinessService extends GenericBusinessServiceImpl<AnneeScolaire,AnneeScolaireDto, Long>{
	private final AnneeScolaireDao dao;
	private final AnneeScolaireMapper mapper;
	
	public AnneeScolaireBusinessService(AnneeScolaireDao dao,AnneeScolaireMapper mapper) {
		super(dao, mapper);
		this.dao = dao;
		this.mapper = mapper;
	}

	public AnneeScolaireDto getAnneeScolaireEncours() {
		Optional<AnneeScolaire> annee = dao.findByEnCours(true);
		if(annee.isPresent()) {
			return mapper.convertirEnDto(annee.get());
		}
		return null;
	}
	
	public AnneeScolaireDto getAnneeScolaireParCode(String code) {
		Optional<AnneeScolaire> annee = dao.findByCode(code);
		return annee.isPresent() ? mapper.convertirEnDto(annee.get()) : null;
	}
}
