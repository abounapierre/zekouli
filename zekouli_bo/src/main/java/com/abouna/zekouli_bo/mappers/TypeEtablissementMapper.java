package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.TypeEtablissementDto;
import com.abouna.zekouli_bo.objet_metiers.TypeEtablissement;

@Mapper
public interface TypeEtablissementMapper extends AbstractMapper<TypeEtablissement, TypeEtablissementDto>{
}
