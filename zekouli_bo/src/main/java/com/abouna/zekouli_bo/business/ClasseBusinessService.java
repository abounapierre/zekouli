package com.abouna.zekouli_bo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.ClasseDto;
import com.abouna.zekouli_bo.mappers.ClasseMapper;
import com.abouna.zekouli_bo.objet_metiers.Classe;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Niveau;
import com.abouna.zekouli_bo.objet_metiers.Serie;
import com.abouna.zekouli_bo.repositories.ClasseDao;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.NiveauDao;
import com.abouna.zekouli_bo.repositories.SerieDao;

@Service
public class ClasseBusinessService extends GenericBusinessServiceImpl<Classe, ClasseDto, Long>{
	private final ClasseDao classeDao;
	private final ClasseMapper mapper;
	@Autowired
	private CycleDao cycleDao;
	@Autowired
	private EtablissementDao etablissementDao;
	@Autowired
	private NiveauDao niveauDao;
	@Autowired
	private SerieDao serieDao;
	
	ClasseBusinessService(ClasseDao jpa, ClasseMapper mapper) {
		super(jpa, mapper);
		this.classeDao = jpa;
		this.mapper = mapper;
	}

	public List<ClasseDto> getListeParCycle(Long id) {
		Optional<Cycle> cycle = cycleDao.findById(id);
		if (cycle.isPresent()) {
			return mapper.convertirEnListeDto(classeDao.findByCycle(cycle.get()));
		}
		return null;
	}

	public List<ClasseDto> getListeParSerie(Long id) {
		Optional<Serie> serie = serieDao.findById(id);
		if (serie.isPresent()) {
			return mapper.convertirEnListeDto(classeDao.findBySerie(serie.get()));
		}
		return null;
	}

	public List<ClasseDto> getListeParNiveau(Long id) {
		Optional<Niveau> niveau = niveauDao.findById(id);
		if (niveau.isPresent()) {
			return mapper.convertirEnListeDto(classeDao.findByNiveau(niveau.get()));
		}
		return null;
	}

	public List<ClasseDto> getListeParEtablissement(Long id) {
		Optional<Etablissement> etablissement = etablissementDao.findById(id);
		if (etablissement.isPresent()) {
			return mapper.convertirEnListeDto(classeDao.findByEtablissement(etablissement.get()));
		}
		return null;
	}
}
