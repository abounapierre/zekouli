package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.SerieModel;
import com.abouna.zekouli_bo.objet_metiers.Serie;

@Mapper
public interface SerieMapper {
	SerieModel sourceToDestination(Serie source);
	Serie destinationToSource(SerieModel destination);
}