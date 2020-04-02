package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.ClasseModel;
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
public class ClasseBusinessService {
	private ClasseMapper mapper = Mappers.getMapper(ClasseMapper.class);
	@Autowired
	private ClasseDao classeDao;
	@Autowired
	private CycleDao cycleDao;
	@Autowired
	private EtablissementDao etablissementDao;
	@Autowired
	private NiveauDao niveauDao;
	@Autowired
	private SerieDao serieDao;

	public ClasseModel enregistrer(ClasseModel classeModel) {
		Classe c = mapper.destinationToSource(classeModel);
		c.setDateCreation(LocalDateTime.now());
		c.setDateModification(LocalDateTime.now());
		c = classeDao.save(c);
		return mapper.sourceToDestination(c);
	}

	public ClasseModel modifier(ClasseModel classeModel, Long id) {
		Optional<Classe> et = classeDao.findById(id);
		Classe e = mapper.destinationToSource(classeModel);
		if (et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = classeDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}

	public ClasseModel getParId(Long id) {
		Optional<Classe> e = classeDao.findById(id);
		return e.isPresent() == true ? mapper.sourceToDestination(e.get()) : null;
	}

	public List<ClasseModel> getliste() {
		return mapper.toClasseModelList(classeDao.findAll());
	}

	public void supprimer(Long id) {
		classeDao.deleteById(id);
	}

	public List<ClasseModel> getListeParCycle(Long id) {
		Optional<Cycle> cycle = cycleDao.findById(id);
		if (cycle.isPresent()) {
			return mapper.toClasseModelList(classeDao.findByCycle(cycle.get()));
		}
		return null;
	}

	public List<ClasseModel> getListeParSerie(Long id) {
		Optional<Serie> serie = serieDao.findById(id);
		if (serie.isPresent()) {
			return mapper.toClasseModelList(classeDao.findBySerie(serie.get()));
		}
		return null;
	}

	public List<ClasseModel> getListeParNiveau(Long id) {
		Optional<Niveau> niveau = niveauDao.findById(id);
		if (niveau.isPresent()) {
			return mapper.toClasseModelList(classeDao.findByNiveau(niveau.get()));
		}
		return null;
	}

	public List<ClasseModel> getListeParEtablissement(Long id) {
		Optional<Etablissement> etablissement = etablissementDao.findById(id);
		if (etablissement.isPresent()) {
			return mapper.toClasseModelList(classeDao.findByEtablissement(etablissement.get()));
		}
		return null;
	}
}
