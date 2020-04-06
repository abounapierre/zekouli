package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.data.dtos.AbstractDto;
import com.abouna.zekouli_bo.mappers.AbstractMapper;
import com.abouna.zekouli_bo.objet_metiers.ObjetMetier;

public abstract class GenericBusinessServiceImpl<T extends ObjetMetier, U extends AbstractDto, ID extends Object> implements GenericBusinessService<U,ID>{
	private final JpaRepository<T, ID> dao;
	private final AbstractMapper<T, U> mapper;
	
	GenericBusinessServiceImpl(JpaRepository<T, ID> jpa,AbstractMapper<T, U> mapper){
		this.dao = jpa;
		this.mapper =mapper;
	}
	

	@Override
	public U modifier(U model, ID id) {
		Optional<T> et = dao.findById(id);
		T e = mapper.convertirObjetMetier(model);
		if (et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = dao.save(e);
			return mapper.convertirEnDto(e);
		}
		return null;
	}

	@Override
	public U getParId(ID id) {
		Optional<T> e = dao.findById(id);
		return e.isPresent() == true ? mapper.convertirEnDto(e.get()) : null;
	}

	@Override
	public void supprimer(ID id) {
		Optional<T> t = dao.findById(id);
		if(t.isPresent()) {
			dao.deleteById(id);
		}
	}

	@Override
	public U enregistrer(U model) {
		T c = mapper.convertirObjetMetier(model);
		c.setDateCreation(LocalDateTime.now());
		c.setDateModification(LocalDateTime.now());
		c = dao.save(c);
		return mapper.convertirEnDto(c);
	}

	@Override
	public List<U> getliste() {
		return mapper.convertirEnListeDto(dao.findAll());
	}


	public JpaRepository<T, ID> getDao() {
		return dao;
	}


	public AbstractMapper<T, U> getMapper() {
		return mapper;
	}
	
	

}
