package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.SequenceDto;
import com.abouna.zekouli_bo.objet_metiers.Sequence;

@Mapper
public interface SequenceMapper extends AbstractMapper<Sequence, SequenceDto>{

}
