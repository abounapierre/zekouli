package com.abouna.zekouli_bo.business.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abouna.zekouli_bo.mappers.AnneeScolaireMapper;
import com.abouna.zekouli_bo.mappers.ClasseMapper;
import com.abouna.zekouli_bo.mappers.CycleMapper;
import com.abouna.zekouli_bo.mappers.EtablissementMapper;
import com.abouna.zekouli_bo.mappers.GroupeMatiereMapper;
import com.abouna.zekouli_bo.mappers.MatiereMapper;
import com.abouna.zekouli_bo.mappers.NiveauMapper;
import com.abouna.zekouli_bo.mappers.SequenceMapper;
import com.abouna.zekouli_bo.mappers.SerieMapper;
import com.abouna.zekouli_bo.mappers.TrimestreMapper;
import com.abouna.zekouli_bo.mappers.TypeEtablissementMapper;

@Configuration
public class SpringConfig {

	@Bean
	TypeEtablissementMapper getTypeEtablissementMapper() {
		return Mappers.getMapper(TypeEtablissementMapper.class);
	}

	@Bean
	EtablissementMapper getEtablissementMapper() {
		return Mappers.getMapper(EtablissementMapper.class);
	}

	@Bean
	AnneeScolaireMapper getAnneeScolaireMapperMapper() {
		return Mappers.getMapper(AnneeScolaireMapper.class);
	}

	@Bean
	ClasseMapper getClasseMapper() {
		return Mappers.getMapper(ClasseMapper.class);
	}

	@Bean
	CycleMapper getCycleMapperMapper() {
		return Mappers.getMapper(CycleMapper.class);
	}

	@Bean
	NiveauMapper getNiveauMapper() {
		return Mappers.getMapper(NiveauMapper.class);
	}

	@Bean
	SerieMapper getSerieMapper() {
		return Mappers.getMapper(SerieMapper.class);
	}
	
	@Bean
	MatiereMapper getMatiereMapper() {
		return Mappers.getMapper(MatiereMapper.class);
	}

	@Bean
	GroupeMatiereMapper getGroupeMatiereMapper() {
		return Mappers.getMapper(GroupeMatiereMapper.class);
	}
	
	@Bean
	TrimestreMapper getTrimestreMapper() {
		return Mappers.getMapper(TrimestreMapper.class);
	}
	
	@Bean
	SequenceMapper getSequenceMapper() {
		return Mappers.getMapper(SequenceMapper.class);
	}
	
}
