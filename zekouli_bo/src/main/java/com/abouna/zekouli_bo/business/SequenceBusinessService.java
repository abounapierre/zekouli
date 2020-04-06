package com.abouna.zekouli_bo.business;

import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.dtos.SequenceDto;
import com.abouna.zekouli_bo.mappers.AbstractMapper;
import com.abouna.zekouli_bo.objet_metiers.Sequence;
import com.abouna.zekouli_bo.repositories.SequenceDao;

@Service
public class SequenceBusinessService extends GenericBusinessServiceImpl<Sequence, SequenceDto, Long>{

	SequenceBusinessService(SequenceDao jpa, AbstractMapper<Sequence, SequenceDto> mapper) {
		super(jpa, mapper);
	}

}
