package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.ClasseDto;
import com.abouna.zekouli_bo.objet_metiers.Classe;

@Mapper
public interface ClasseMapper extends AbstractMapper<Classe, ClasseDto>{

}
