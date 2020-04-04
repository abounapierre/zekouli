package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.AnneeScolaireDto;
import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;

@Mapper
public interface AnneeScolaireMapper extends AbstractMapper<AnneeScolaire, AnneeScolaireDto>{
	
}
