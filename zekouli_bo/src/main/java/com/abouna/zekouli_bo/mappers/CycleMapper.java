package com.abouna.zekouli_bo.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.CycleModel;
import com.abouna.zekouli_bo.objet_metiers.Cycle;

@Mapper
public interface CycleMapper {
	CycleModel sourceToDestination(Cycle source);
	Cycle destinationToSource(CycleModel destination);
	List<CycleModel> toCycleModelList(List<Cycle> findAll);
	List<CycleModel> toCycleList(List<CycleModel> findAll);
}
