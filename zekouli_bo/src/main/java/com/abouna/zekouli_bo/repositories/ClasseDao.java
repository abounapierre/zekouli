package com.abouna.zekouli_bo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abouna.zekouli_bo.objet_metiers.Classe;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.Niveau;
import com.abouna.zekouli_bo.objet_metiers.Serie;

public interface ClasseDao extends JpaRepository<Classe, Long>{
	@Query("SELECT e FROM Classe e WHERE e.serie.etablissement = :etablissement OR e.niveau.etablissement = :etablissement OR e.cycle.etablissement = :etablissement")
	List<Classe> findByEtablissement(@Param("etablissement") Etablissement etablissement);
	
	@Query("SELECT e FROM Classe e WHERE e.cycle = :cycle")
	List<Classe> findByCycle(@Param("cycle") Cycle cycle);
	
	@Query("SELECT e FROM Classe e WHERE e.niveau = :niveau")
	List<Classe> findByNiveau(@Param("niveau") Niveau niveau);
	
	@Query("SELECT e FROM Classe e WHERE e.serie = :serie")
	List<Classe> findBySerie(@Param("serie") Serie serie);
}
