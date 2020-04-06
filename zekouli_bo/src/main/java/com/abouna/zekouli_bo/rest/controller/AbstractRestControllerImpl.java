package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import com.abouna.zekouli_bo.business.GenericBusinessService;
import com.abouna.zekouli_bo.data.dtos.AbstractDto;

public abstract class AbstractRestControllerImpl<T extends AbstractDto, ID extends Object> implements AbstractRestController<T, ID>{
	private final GenericBusinessService<T, ID> service;

	public AbstractRestControllerImpl(GenericBusinessService<T, ID> service){
		this.service = service;
	}
	
	@Override
	public T enregistrer(T r) {
		return service.enregistrer(r);
	}

	@Override
	public T modifier(T r, ID id) {
		return service.modifier(r, id);
	}

	@Override
	public T getParId(ID id) {
		return service.getParId(id);
	}

	@Override
	public List<T> getliste() {
		return service.getliste();
	}

	@Override
	public void supprimer(ID id) {
		service.supprimer(id);
	}

}