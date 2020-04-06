package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.TrimestreDto;
import com.abouna.zekouli_bo.objet_metiers.Trimestre;

@Mapper
public interface TrimestreMapper extends AbstractMapper<Trimestre, TrimestreDto>{

}
