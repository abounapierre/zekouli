package com.abouna.zekouli_bo.mappers;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.dtos.InscriptionDto;
import com.abouna.zekouli_bo.objet_metiers.Inscription;

@Mapper
public interface InscriptionMapper extends AbstractMapper<Inscription, InscriptionDto>{

}
