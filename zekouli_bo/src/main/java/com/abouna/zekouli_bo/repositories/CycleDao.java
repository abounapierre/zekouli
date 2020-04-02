package com.abouna.zekouli_bo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;

public interface CycleDao extends JpaRepository<Cycle, Long>{
	public List<Cycle> findByEtablissement(Etablissement etablissement);
}
