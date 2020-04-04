package com.abouna.zekouli_bo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.NiveauDto;
import com.abouna.zekouli_bo.mappers.NiveauMapper;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Niveau;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.NiveauDao;

@Service
public class NiveauBusinessService extends GenericBusinessServiceImpl<Niveau, NiveauDto, Long>{
	
	private final NiveauDao niveauDao;
	private final NiveauMapper mapper;
	@Autowired
	private EtablissementDao etablissementDao;
	@Autowired
	private CycleDao cycleDao;
	
	
	NiveauBusinessService(NiveauDao jpa, NiveauMapper mapper) {
		super(jpa, mapper);
		this.niveauDao = jpa;
		this.mapper = mapper;
	}

	public List<NiveauDto> getListeParEtablissement(Long id) {
		Optional<Etablissement> etablissement = etablissementDao.findById(id);
		if(etablissement.isPresent()) {
			return mapper.convertirEnListeDto(niveauDao.findByEtablissement(etablissement.get()));
		}
		return null;
	}

	public List<NiveauDto> getListeParCycle(Long id) {
		Optional<Cycle> cycle = cycleDao.findById(id);
		if(cycle.isPresent()) {
			return mapper.convertirEnListeDto(niveauDao.findByCycle(cycle.get()));
		}
		return null;
	}
}
