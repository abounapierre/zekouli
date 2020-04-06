package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.ClasseDto;

import feign.Param;
import feign.RequestLine;

public interface ClasseProxy extends AbstractProxy<ClasseDto, Long>{
	@RequestLine("GET /etablissement/{id}")
	List<ClasseDto> getListeClasseParEtablissement(@Param("id") Long id);

}
