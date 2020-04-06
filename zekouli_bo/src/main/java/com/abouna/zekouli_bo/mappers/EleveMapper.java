package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.EleveDto;
import com.abouna.zekouli_bo.objet_metiers.Eleve;

@Mapper
public interface EleveMapper extends AbstractMapper<Eleve, EleveDto>{

}
