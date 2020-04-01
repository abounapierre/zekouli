package com.abouna.zekouli_bo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Etablissement;

public interface EtablissementDao extends JpaRepository<Etablissement, Long>{

}
