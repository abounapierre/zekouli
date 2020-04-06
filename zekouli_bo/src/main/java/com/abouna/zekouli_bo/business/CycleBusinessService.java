package com.abouna.zekouli_bo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.dtos.CycleDto;
import com.abouna.zekouli_bo.mappers.CycleMapper;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;

@Service
public class CycleBusinessService extends GenericBusinessServiceImpl<Cycle, CycleDto, Long>{
	private final CycleDao cycleDao;
	@Autowired
	private EtablissementDao etablissementDao;
	private final CycleMapper mapper;

	CycleBusinessService(CycleDao jpa, CycleMapper mapper) {
		super(jpa, mapper);
		this.cycleDao = jpa;
		this.mapper = mapper;
	}
	
	public List<CycleDto> getListeParEtablissement(Long id){
		Optional<Etablissement> e = etablissementDao.findById(id);
		if(e.isPresent()) {
			return mapper.convertirEnListeDto(cycleDao.findByEtablissement(e.get()));
		}
		return  null;
	}

}
