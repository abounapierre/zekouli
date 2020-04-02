package com.abouna.zekouli_bo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Serie;

public interface SerieDao extends JpaRepository<Serie, Long>{
	List<Serie> findByEtablissement(Etablissement etablissement);
}
