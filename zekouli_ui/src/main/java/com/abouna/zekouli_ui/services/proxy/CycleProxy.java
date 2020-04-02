package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.models.CycleModel;

import feign.Param;
import feign.RequestLine;

public interface CycleProxy extends AbstractProxy<CycleModel, Long>{

	@RequestLine("GET /etablissement/{id}")
	List<CycleModel> getListeParEtablissement(@Param("id") Long id);

}
