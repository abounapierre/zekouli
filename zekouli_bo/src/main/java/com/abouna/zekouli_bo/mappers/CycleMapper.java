package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.CycleDto;
import com.abouna.zekouli_bo.objet_metiers.Cycle;

@Mapper
public interface CycleMapper extends AbstractMapper<Cycle, CycleDto>{
}
