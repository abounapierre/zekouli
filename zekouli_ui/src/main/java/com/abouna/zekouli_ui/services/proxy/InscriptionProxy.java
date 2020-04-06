package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.InscriptionDto;

import feign.Param;
import feign.RequestLine;

public interface InscriptionProxy extends AbstractProxy<InscriptionDto, Long>{
	@RequestLine("GET /{idAnnee}/{idEleve}")
	public InscriptionDto getInscriptionAnneeEleve(@Param("idAnnee") Long idAnnee, @Param("idEleve") Long idEleve);

	@RequestLine("GET /recherche?classe={idClasse}&anneeScolaire={idAnnee}")
	public List<InscriptionDto> getListeParClasse(@Param("idClasse") Long idClasse, @Param("idAnnee") Long idAnnee);
}
