package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.NiveauModel;
import com.abouna.zekouli_bo.mappers.NiveauMapper;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Niveau;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.NiveauDao;

@Service
public class NiveauBusinessService {
	@Autowired
	private NiveauDao niveauDao;
	@Autowired
	private EtablissementDao etablissementDao;
	@Autowired
	private CycleDao cycleDao;
	private NiveauMapper mapper = Mappers.getMapper(NiveauMapper.class);

	public NiveauModel enregistrer(NiveauModel r) {
		Niveau e = mapper.destinationToSource(r);
		e.setDateCreation(LocalDateTime.now());
		e.setDateModification(LocalDateTime.now());
		e = niveauDao.save(e);
		return mapper.sourceToDestination(e);
	}

	public NiveauModel modifier(NiveauModel r, Long id) {
		Optional<Niveau> et = niveauDao.findById(id);
		Niveau e = mapper.destinationToSource(r);
		if (et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = niveauDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}

	public NiveauModel getParId(Long id) {
		Optional<Niveau> e = niveauDao.findById(id);
		return e.isPresent() == true ? mapper.sourceToDestination(e.get()) : null;
	}

	public List<NiveauModel> getliste() {
		return mapper.toNiveauModelList(niveauDao.findAll());
	}

	public void supprimer(Long id) {
		niveauDao.deleteById(id);
	}

	public List<NiveauModel> getListeParEtablissement(Long id) {
		Optional<Etablissement> etablissement = etablissementDao.findById(id);
		if(etablissement.isPresent()) {
			return mapper.toNiveauModelList(niveauDao.findByEtablissement(etablissement.get()));
		}
		return null;
	}

	public List<NiveauModel> getListeParCycle(Long id) {
		Optional<Cycle> cycle = cycleDao.findById(id);
		if(cycle.isPresent()) {
			return mapper.toNiveauModelList(niveauDao.findByCycle(cycle.get()));
		}
		return null;
	}
}
