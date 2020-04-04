package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.NiveauDto;

import feign.Param;
import feign.RequestLine;

public interface NiveauProxy extends AbstractProxy<NiveauDto, Long>{

	@RequestLine("GET /etablissement/{id}")
	List<NiveauDto> getListeParEtablissement(@Param("id") Long id);

	@RequestLine("GET /cycle/{id}")
	List<NiveauDto> getListeParCycle(@Param("id") Long id);

}
