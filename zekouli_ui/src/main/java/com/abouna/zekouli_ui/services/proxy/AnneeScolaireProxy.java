package com.abouna.zekouli_ui.services.proxy;

import com.abouna.zekouli_ui.data.dtos.AnneeScolaireDto;

import feign.Param;
import feign.RequestLine;

public interface AnneeScolaireProxy extends AbstractProxy<AnneeScolaireDto, Long>{
	@RequestLine("GET /encours")
	public AnneeScolaireDto getAnneeScolaireEncours();
	
	@RequestLine("GET /recherche?code={code}")
	public AnneeScolaireDto getAnneeScolaireParCode(@Param("code") String code);
}
