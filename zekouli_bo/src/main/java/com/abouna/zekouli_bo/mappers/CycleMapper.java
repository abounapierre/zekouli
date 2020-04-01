package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.CycleModel;
import com.abouna.zekouli_bo.objet_metiers.Cycle;

@Mapper
public interface CycleMapper {
	CycleModel sourceToDestination(Cycle source);
	Cycle destinationToSource(CycleModel destination);
}
