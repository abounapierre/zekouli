package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.CycleDto;

import feign.Param;
import feign.RequestLine;

public interface CycleProxy extends AbstractProxy<CycleDto, Long>{

	@RequestLine("GET /etablissement/{id}")
	List<CycleDto> getListeParEtablissement(@Param("id") Long id);

}
