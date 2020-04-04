package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.TypeEtablissementDto;
import com.abouna.zekouli_bo.mappers.TypeEtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.TypeEtablissement;
import com.abouna.zekouli_bo.repositories.TypeEtablissementDao;

@Service
public class TypeEtablissmentBusinessService extends GenericBusinessServiceImpl<TypeEtablissement, TypeEtablissementDto, Long>{

	TypeEtablissmentBusinessService(TypeEtablissementDao dao,
			TypeEtablissementMapper mapper) {
		super(dao, mapper);
	}

}
