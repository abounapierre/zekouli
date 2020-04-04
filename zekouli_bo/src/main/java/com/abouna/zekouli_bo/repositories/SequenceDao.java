package com.abouna.zekouli_bo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abouna.zekouli_bo.objet_metiers.Sequence;
import com.abouna.zekouli_bo.objet_metiers.Trimestre;

public interface SequenceDao extends JpaRepository<Sequence, Long>{
	List<Sequence> findByTrimestre(Trimestre trimestre);
}
