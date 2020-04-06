package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.business.utils.BusinessUtils;
import com.abouna.zekouli_bo.data.dtos.EleveDto;
import com.abouna.zekouli_bo.data.dtos.EleveInscritDto;
import com.abouna.zekouli_bo.mappers.EleveMapper;
import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;
import com.abouna.zekouli_bo.objet_metiers.Eleve;
import com.abouna.zekouli_bo.objet_metiers.Matricule;
import com.abouna.zekouli_bo.repositories.AnneeScolaireDao;
import com.abouna.zekouli_bo.repositories.EleveDao;
import com.abouna.zekouli_bo.repositories.MatriculeDao;

@Service
public class EleveBusinessService extends GenericBusinessServiceImpl<Eleve, EleveDto, Long> {
	private final EleveMapper mapper;
	private final EleveDao dao;
	@Autowired
	private AnneeScolaireDao anneeDao;
	@Autowired
	private MatriculeDao matriculeDao;

	EleveBusinessService(EleveDao jpa, EleveMapper mapper) {
		super(jpa, mapper);
		this.dao = jpa;
		this.mapper = mapper;

	}

	@Override
	public EleveDto enregistrer(EleveDto dto) {
		if (dto.getMatricule() == null || dto.getMatricule().isEmpty()) {
			Optional<Matricule> m = matriculeDao.findTopByOrderByIdDesc();
			int a = 1;
			if(m.isPresent()) {
				a = Integer.valueOf(m.get().getValeur().split("M")[1]) + 1;
			}
			String matricule = BusinessUtils.getMatricule(a);
			dto.setMatricule(matricule);
		}
		dto.setDateCreation(LocalDateTime.now());
		dto.setDateModification(LocalDateTime.now());
		EleveDto edto = mapper.convertirEnDto(dao.save(mapper.convertirObjetMetier(dto)));
		if(edto!=null) {
			Matricule m1 = new Matricule();
			m1.setDateCreation(LocalDateTime.now());
			m1.setDateModification(LocalDateTime.now());
			m1.setUtilisateur(edto.getUtilisateur());
			m1.setValeur(edto.getMatricule());
			matriculeDao.save(m1);
		}
		return edto;
	}
	
	@Override
	public void supprimer(Long id) {
		Optional<Eleve> e = dao.findById(id);
		if(e.isPresent()) {
			dao.deleteById(id);
			Optional<Matricule> m = matriculeDao.findByValeur(e.get().getMatricule());
			if(m.isPresent()) {
				matriculeDao.deleteById(m.get().getId());
			}
		}
	}
	
	public List<EleveInscritDto> getListeEleveInscrits(Long id){
		Optional<AnneeScolaire> anneeScolaire = anneeDao.findById(id);
		if(anneeScolaire.isPresent()) {
			return dao.getListeElevenscrits(anneeScolaire.get());
		}
		return null;
	}

	public List<EleveDto> getListeEleveParNomOuMatricule(String matricule, String nom) {
		if(matricule != null && !matricule.isEmpty()) {
			return mapper.convertirEnListeDto(dao.findByMatricule(matricule));
		}else if(nom != null && !nom.isEmpty()) {
			return mapper.convertirEnListeDto(dao.findByNomLike("%".concat(nom).concat("%")));
		}
		return Collections.emptyList();
	}

}
