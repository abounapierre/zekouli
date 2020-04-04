package com.abouna.zekouli_ui.services;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.AbstractDto;
import com.abouna.zekouli_ui.services.proxy.AbstractProxy;

public abstract class AbstractServiceImpl<dto extends AbstractDto,ID extends Object> implements AbstractService<dto, ID>{

	private final AbstractProxy<dto, ID> proxy;
	
	public AbstractServiceImpl(AbstractProxy<dto, ID> proxy) {
		this.proxy = proxy;
	}

	@Override
	public List<dto> getListe() {
		return proxy.getList();
	}

	@Override
	public dto enregistrerOuModifier(dto t, ID id) {
		if (t.getId() == null) {
			return proxy.enregistrer(t);
		}
		return proxy.modifier(t, id);
	}

	@Override
	public dto obtenirParId(ID id) {
		return proxy.getParId(id);
	}

	@Override
	public void supprimer(ID id) {
		proxy.supprimer(id);
	}
	
}
