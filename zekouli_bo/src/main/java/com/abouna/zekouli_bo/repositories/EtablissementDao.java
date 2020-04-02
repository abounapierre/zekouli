package com.abouna.zekouli_bo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.objet_metiers.TypeEtablissement;

public interface EtablissementDao extends JpaRepository<Etablissement, Long>{
 List<Etablissement> findByTypeEtablissement(TypeEtablissement typeEtablissement);
}
