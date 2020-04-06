package com.abouna.zekouli_bo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Matricule;

public interface MatriculeDao extends JpaRepository<Matricule, Long>{
	Optional<Matricule> findTopByOrderByIdDesc();
	Optional<Matricule> findByValeur(String valeur);
}
