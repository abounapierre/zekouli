package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.GroupeMatiereDto;
import com.abouna.zekouli_bo.objet_metiers.GroupeMatiere;

@Mapper
public interface GroupeMatiereMapper extends AbstractMapper<GroupeMatiere, GroupeMatiereDto>{

}
