package com.abouna.zekouli_bo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;

public interface AnneeScolaireDao extends JpaRepository<AnneeScolaire, Long>{
	Optional<AnneeScolaire> findByEnCours(boolean enCours);

	Optional<AnneeScolaire> findByCode(String code);
}
