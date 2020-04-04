package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.AnneeScolaireDto;
import com.abouna.zekouli_bo.mappers.AnneeScolaireMapper;
import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;
import com.abouna.zekouli_bo.repositories.AnneeScolaireDao;

@Service
public class AnneeScolaireBusinessService extends GenericBusinessServiceImpl<AnneeScolaire,AnneeScolaireDto, Long>{
	
	public AnneeScolaireBusinessService(AnneeScolaireDao dao,AnneeScolaireMapper mapper) {
		super(dao, mapper);
	}

}
