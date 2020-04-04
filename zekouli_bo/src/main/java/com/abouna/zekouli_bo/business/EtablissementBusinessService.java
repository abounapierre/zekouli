package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.EtablissementDto;
import com.abouna.zekouli_bo.mappers.EtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.repositories.EtablissementDao;

@Service
public class EtablissementBusinessService extends GenericBusinessServiceImpl<Etablissement, EtablissementDto, Long> {
	EtablissementBusinessService(EtablissementDao jpa, EtablissementMapper mapper) {
		super(jpa, mapper);
	}

}
