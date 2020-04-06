package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.dtos.TrimestreDto;
import com.abouna.zekouli_bo.mappers.TrimestreMapper;
import com.abouna.zekouli_bo.objet_metiers.Trimestre;
import com.abouna.zekouli_bo.repositories.TrimestreDao;

/**
 * 
 * @author abouna
 *
 */
@Service
public class TrimestreBusinessService extends GenericBusinessServiceImpl<Trimestre, TrimestreDto, Long>{

	public TrimestreBusinessService(TrimestreDao jpa, TrimestreMapper mapper) {
		super(jpa, mapper);
	}

}
