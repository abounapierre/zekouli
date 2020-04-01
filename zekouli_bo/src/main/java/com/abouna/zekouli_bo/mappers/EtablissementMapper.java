package com.abouna.zekouli_bo.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.EtablissementModel;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;

@Mapper
public interface EtablissementMapper {
	EtablissementModel sourceToDestination(Etablissement source);
	Etablissement destinationToSource(EtablissementModel destination);
	List<EtablissementModel> toEtablissementModel(
		      Collection<Etablissement> etablissements);
	List<Etablissement> toEtablissement(
		      Collection<EtablissementModel> etablissementModels);
}
