package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.ClasseModel;
import com.abouna.zekouli_bo.objet_metiers.Classe;

@Mapper
public interface ClasseMapper {
	ClasseModel sourceToDestination(Classe source);
	Classe destinationToSource(ClasseModel destination);
}
