package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.models.GroupeMatiereDto;
import com.abouna.zekouli_bo.mappers.GroupeMatiereMapper;
import com.abouna.zekouli_bo.objet_metiers.GroupeMatiere;
import com.abouna.zekouli_bo.repositories.GroupeMatiereDao;

@Service
public class GroupeMatiereBusinessService extends GenericBusinessServiceImpl<GroupeMatiere, GroupeMatiereDto, Long> {

	GroupeMatiereBusinessService(GroupeMatiereDao jpa, GroupeMatiereMapper mapper) {
		super(jpa, mapper);
	}

}
