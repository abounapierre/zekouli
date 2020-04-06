package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.SerieDto;
import com.abouna.zekouli_bo.objet_metiers.Serie;

@Mapper
public interface SerieMapper extends AbstractMapper<Serie, SerieDto>{
	
}
