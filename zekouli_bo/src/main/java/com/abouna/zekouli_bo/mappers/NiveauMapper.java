package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.NiveauModel;
import com.abouna.zekouli_bo.objet_metiers.Niveau;

@Mapper
public interface NiveauMapper {
	NiveauModel sourceToDestination(Niveau source);
	Niveau destinationToSource(NiveauModel destination);
}
