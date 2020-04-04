package com.abouna.zekouli_bo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.SerieDto;
import com.abouna.zekouli_bo.mappers.SerieMapper;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Serie;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.SerieDao;
/**
 * 
 * @author abouna
 *
 */
@Service
public class SerieBusinessService extends GenericBusinessServiceImpl<Serie, SerieDto, Long> {

	private final SerieDao serieDao;
	private final SerieMapper mapper;
	@Autowired
	private EtablissementDao etablissementDao;

	SerieBusinessService(SerieDao jpa, SerieMapper mapper) {
		super(jpa, mapper);
		this.serieDao = jpa;
		this.mapper = mapper;
	}

	public List<SerieDto> getListeParEtablissement(Long id) {
		Optional<Etablissement> e = etablissementDao.findById(id);
		if (e.isPresent()) {
			return mapper.convertirEnListeDto(serieDao.findByEtablissement(e.get()));
		}
		return null;
	}
}
