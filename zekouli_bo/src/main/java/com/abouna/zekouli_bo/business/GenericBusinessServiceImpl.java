package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.data.models.AbstractDto;
import com.abouna.zekouli_bo.mappers.AbstractMapper;
import com.abouna.zekouli_bo.objet_metiers.ObjetMetier;

public abstract class GenericBusinessServiceImpl<T extends ObjetMetier, U extends AbstractDto, ID extends Object> implements GenericBusinessService<U,ID>{
	private final JpaRepository<T, ID> jpa;
	private final AbstractMapper<T, U> mapper;
	
	GenericBusinessServiceImpl(JpaRepository<T, ID> jpa,AbstractMapper<T, U> mapper){
		this.jpa = jpa;
		this.mapper =mapper;
	}
	

	@Override
	public U modifier(U model, ID id) {
		Optional<T> et = jpa.findById(id);
		T e = mapper.convertirObjetMetier(model);
		if (et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = jpa.save(e);
			return mapper.convertirEnDto(e);
		}
		return null;
	}

	@Override
	public U getParId(ID id) {
		Optional<T> e = jpa.findById(id);
		return e.isPresent() == true ? mapper.convertirEnDto(e.get()) : null;
	}

	@Override
	public void supprimer(ID id) {
		Optional<T> t = jpa.findById(id);
		if(t.isPresent()) {
			jpa.deleteById(id);
		}
	}

	@Override
	public U enregistrer(U model) {
		T c = mapper.convertirObjetMetier(model);
		c.setDateCreation(LocalDateTime.now());
		c.setDateModification(LocalDateTime.now());
		c = jpa.save(c);
		return mapper.convertirEnDto(c);
	}

	@Override
	public List<U> getliste() {
		return mapper.convertirEnListeDto(jpa.findAll());
	}

}
