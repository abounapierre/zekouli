package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.SerieModel;
import com.abouna.zekouli_bo.mappers.SerieMapper;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Serie;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.SerieDao;

@Service
public class SerieBusinessService {
	@Autowired
	private SerieDao serieDao;
	@Autowired
	private EtablissementDao etablissementDao;
	private SerieMapper mapper = Mappers.getMapper(SerieMapper.class);

	public SerieModel enregistrer(SerieModel r) {
		Serie e = mapper.destinationToSource(r);
		e.setDateCreation(LocalDateTime.now());
		e.setDateModification(LocalDateTime.now());
		e = serieDao.save(e);
		return mapper.sourceToDestination(e);
	}

	public SerieModel modifier(SerieModel r, Long id) {
		Optional<Serie> et = serieDao.findById(id);
		Serie e = mapper.destinationToSource(r);
		if (et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = serieDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}

	public SerieModel getParId(Long id) {
		Optional<Serie> e = serieDao.findById(id);
		return e.isPresent() == true ? mapper.sourceToDestination(e.get()) : null;
	}

	public List<SerieModel> getliste() {
		return mapper.toSerieModelList(serieDao.findAll());
	}

	public void supprimer(Long id) {
		serieDao.deleteById(id);
	}

	public List<SerieModel> getListeParEtablissement(Long id) {
		Optional<Etablissement> e = etablissementDao.findById(id);
		if(e.isPresent()) {
			return mapper.toSerieModelList(serieDao.findByEtablissement(e.get()));
		}
		return  null;
	}
}
