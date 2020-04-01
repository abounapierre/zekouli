package com.abouna.zekouli_bo.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.TypeEtablissementModel;
import com.abouna.zekouli_bo.objet_metiers.TypeEtablissement;

@Mapper
public interface TypeEtablissementMapper {
	TypeEtablissementModel sourceToDestination(TypeEtablissement source);
	TypeEtablissement destinationToSource(TypeEtablissementModel destination);
	List<TypeEtablissementModel> toTypeEtablissementModelList(
		      Collection<TypeEtablissement> typeEtablissements);
	List<TypeEtablissement> toTypeEtablissementList(
		      Collection<TypeEtablissementModel> typeEtablissementModels);
}
