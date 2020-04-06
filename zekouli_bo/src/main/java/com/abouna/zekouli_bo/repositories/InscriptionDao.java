package com.abouna.zekouli_bo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;
import com.abouna.zekouli_bo.objet_metiers.Classe;
import com.abouna.zekouli_bo.objet_metiers.Eleve;
import com.abouna.zekouli_bo.objet_metiers.Inscription;

public interface InscriptionDao extends JpaRepository<Inscription, Long>{
	List<Inscription> findByAnneeScolaireAndClasse(AnneeScolaire anneeScolaire,Classe classe);
	List<Inscription> findByAnneeScolaire(AnneeScolaire anneeScolaire);
	Optional<Inscription> findByAnneeScolaireAndEleve(AnneeScolaire anneeScolaire, Eleve eleve);
}
