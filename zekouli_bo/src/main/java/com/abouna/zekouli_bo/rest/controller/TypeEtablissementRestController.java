package com.abouna.zekouli_bo.rest.controller;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.data.models.TypeEtablissementModel;
import com.abouna.zekouli_bo.mappers.TypeEtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.TypeEtablissement;
import com.abouna.zekouli_bo.repositories.TypeEtablissementDao;

@RestController
@RequestMapping("/type-etablissements")
public class TypeEtablissementRestController implements AbstractRestController<TypeEtablissementModel, Long>{
	@Autowired
	private TypeEtablissementDao typeEtablissementDao;
	private TypeEtablissementMapper mapper= Mappers.getMapper(TypeEtablissementMapper.class);

	@Override
	public TypeEtablissementModel enregistrer(TypeEtablissementModel r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeEtablissementModel modifier(TypeEtablissementModel typeEtablissementModel, Long id) {
		Optional<TypeEtablissement> et = typeEtablissementDao.findById(id);
		TypeEtablissement e = mapper.destinationToSource(typeEtablissementModel);
		if(et.isPresent()) {
			e.setId(id);
			e = typeEtablissementDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}

	@Override
	public TypeEtablissementModel getParId(Long id) {
		Optional<TypeEtablissement> typeEtablissment = typeEtablissementDao.findById(id);
		if(typeEtablissment.isPresent()) {
			return mapper.sourceToDestination(typeEtablissment.get());
		}
		return null;
	}

	@Override
	public List<TypeEtablissementModel> getliste() {
		return mapper.toTypeEtablissementModelList(typeEtablissementDao.findAll());
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
