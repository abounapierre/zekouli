package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.NiveauDto;
import com.abouna.zekouli_bo.objet_metiers.Niveau;

@Mapper
public interface NiveauMapper extends AbstractMapper<Niveau, NiveauDto>{
}
