package com.abouna.zekouli_bo.business;

import java.util.List;

import com.abouna.zekouli_bo.data.dtos.AbstractDto;

public interface GenericBusinessService <U extends AbstractDto,ID extends Object>{
	public U enregistrer(U model);

	public U modifier(U model, ID id);

	public U getParId(ID id);

	public List<U> getliste();

	public void supprimer(ID id);
}
