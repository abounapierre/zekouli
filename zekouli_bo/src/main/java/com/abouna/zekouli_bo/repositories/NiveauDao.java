package com.abouna.zekouli_bo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Niveau;

public interface NiveauDao extends JpaRepository<Niveau, Long>{
	List<Niveau> findByEtablissement(Etablissement etablissement);
	List<Niveau> findByCycle(Cycle cycle);
}
