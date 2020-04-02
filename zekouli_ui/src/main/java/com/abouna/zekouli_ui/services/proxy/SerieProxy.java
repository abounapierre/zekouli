package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.models.SerieModel;

import feign.Param;
import feign.RequestLine;

public interface SerieProxy extends AbstractProxy<SerieModel, Long>{
	@RequestLine("GET /etablissement/{id}")
	List<SerieModel> getListeParEtablissement(@Param("id") Long id);
}
