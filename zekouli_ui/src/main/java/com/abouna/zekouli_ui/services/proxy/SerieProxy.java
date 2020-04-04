package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.SerieDto;

import feign.Param;
import feign.RequestLine;

public interface SerieProxy extends AbstractProxy<SerieDto, Long>{
	@RequestLine("GET /etablissement/{id}")
	List<SerieDto> getListeParEtablissement(@Param("id") Long id);
}
