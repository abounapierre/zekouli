package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.dtos.MatiereDto;
import com.abouna.zekouli_bo.mappers.MatiereMapper;
import com.abouna.zekouli_bo.objet_metiers.Matiere;
import com.abouna.zekouli_bo.repositories.MatiereDao;

@Service
public class MatiereBusinessService extends GenericBusinessServiceImpl<Matiere, MatiereDto, Long>{

	MatiereBusinessService(MatiereDao jpa, MatiereMapper mapper) {
		super(jpa, mapper);
	}

}
