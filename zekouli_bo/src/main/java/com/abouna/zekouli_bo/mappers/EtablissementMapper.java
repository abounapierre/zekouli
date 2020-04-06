package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.EtablissementDto;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;

@Mapper
public interface EtablissementMapper extends AbstractMapper<Etablissement, EtablissementDto>{
}
