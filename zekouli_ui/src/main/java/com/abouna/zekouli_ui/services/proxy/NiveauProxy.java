package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.models.NiveauModel;

import feign.Param;
import feign.RequestLine;

public interface NiveauProxy extends AbstractProxy<NiveauModel, Long>{

	@RequestLine("GET /etablissement/{id}")
	List<NiveauModel> getListeParEtablissement(@Param("id") Long id);

	@RequestLine("GET /cycle/{id}")
	List<NiveauModel> getListeParCycle(@Param("id") Long id);

}
