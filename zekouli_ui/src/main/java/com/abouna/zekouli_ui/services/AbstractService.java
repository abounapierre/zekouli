package com.abouna.zekouli_ui.services;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.AbstractDto;

public interface AbstractService<T extends AbstractDto,ID extends Object>{
	T enregistrerOuModifier(T t,ID id);
	List<T> getListe();
	T obtenirParId(ID id);
	void supprimer(ID id);
}
