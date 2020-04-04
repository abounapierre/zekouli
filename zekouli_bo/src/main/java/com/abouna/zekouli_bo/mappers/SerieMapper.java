package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.SerieDto;
import com.abouna.zekouli_bo.objet_metiers.Serie;

@Mapper
public interface SerieMapper extends AbstractMapper<Serie, SerieDto>{
	
}
