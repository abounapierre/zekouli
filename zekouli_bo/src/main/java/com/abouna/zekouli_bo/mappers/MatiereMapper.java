package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.MatiereDto;
import com.abouna.zekouli_bo.objet_metiers.Matiere;

@Mapper
public interface MatiereMapper extends AbstractMapper<Matiere, MatiereDto>{

}
