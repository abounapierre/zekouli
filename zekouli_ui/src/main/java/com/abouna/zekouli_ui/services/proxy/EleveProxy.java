package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.EleveDto;
import com.abouna.zekouli_ui.data.dtos.EleveInscritDto;

import feign.Param;
import feign.RequestLine;

public interface EleveProxy extends AbstractProxy<EleveDto, Long>{
	@RequestLine("GET /recherche?nom={nom}&matricule={matricule}")
	List<EleveDto> getListeParMatriculeOuNom(@Param("matricule") String matricule, @Param("nom") String nom);
	@RequestLine("GET /inscrit/anneeScolaire?id={id}")
	List<EleveInscritDto> getEleveInscrits(@Param("id") Long id);

}
