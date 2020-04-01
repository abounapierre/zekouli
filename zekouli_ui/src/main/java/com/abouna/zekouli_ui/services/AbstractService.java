package com.abouna.zekouli_ui.services;

import java.util.List;

import com.abouna.zekouli_ui.data.models.AbstractModel;

public abstract class AbstractService<T extends AbstractModel,ID extends Object>{
	
	protected abstract T enregistrerOuModifier(T t);
	protected abstract List<T> getListe();
	protected abstract T obtenirParId(ID id);
	protected abstract void supprimer(ID id);
}
