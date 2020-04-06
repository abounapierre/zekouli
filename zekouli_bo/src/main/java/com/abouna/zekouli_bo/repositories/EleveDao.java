package com.abouna.zekouli_bo.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abouna.zekouli_bo.data.dtos.EleveInscritDto;
import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;
import com.abouna.zekouli_bo.objet_metiers.Eleve;

public interface EleveDao extends JpaRepository<Eleve, Long> {
	List<Eleve> findByDateCreationGreaterThanEqualAndNouveau(LocalDateTime dateCreation, boolean nouveau);

	@Query("SELECT DISTINCT new com.abouna.zekouli_bo.data.dtos.EleveInscritDto(i.id, e.nom, e.prenom, e.matricule, a.code, c.libelle) "
			+ "FROM Eleve e, Inscription i, AnneeScolaire a, Classe c WHERE c = i.classe AND i.eleve = e AND i.anneeScolaire = a AND a = :anneeScolaire")
	List<EleveInscritDto> getListeElevenscrits(@Param("anneeScolaire") AnneeScolaire anneeScolaire);

	List<Eleve> findByMatricule(String matricule);

	List<Eleve> findByNomLike(String nom);
}
