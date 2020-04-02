package com.abouna.zekouli_bo.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.abouna.zekouli_bo.data.models.ClasseModel;
import com.abouna.zekouli_bo.data.models.NiveauModel;
import com.abouna.zekouli_bo.objet_metiers.Classe;
import com.abouna.zekouli_bo.objet_metiers.Niveau;

@Mapper
public interface ClasseMapper {
	ClasseModel sourceToDestination(Classe source);
	Classe destinationToSource(ClasseModel destination);
	List<ClasseModel> toClasseModelList(List<Classe> findAll);
	List<Classe> toClasseList(List<ClasseModel> findAll);
	List<NiveauModel> toNiveauModelList(List<Niveau> findAll);
	List<Niveau> toNiveauList(List<NiveauModel> findAll);
}
