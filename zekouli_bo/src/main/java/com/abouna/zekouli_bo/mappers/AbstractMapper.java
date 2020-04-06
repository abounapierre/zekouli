package com.abouna.zekouli_bo.mappers;

import java.util.List;

import com.abouna.zekouli_bo.data.dtos.AbstractDto;
import com.abouna.zekouli_bo.objet_metiers.ObjetMetier;

public interface AbstractMapper <T extends ObjetMetier,V extends AbstractDto>{
	V convertirEnDto(T objetMetier);
	T convertirObjetMetier(V model);
	List<V> convertirEnListeDto(List<T> list);
	List<T> convertirListeObjetMetier(List<V> list);
}
