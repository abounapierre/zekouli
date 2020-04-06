package com.abouna.zekouli_bo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abouna.zekouli_bo.data.dtos.InscriptionDto;
import com.abouna.zekouli_bo.mappers.AbstractMapper;
import com.abouna.zekouli_bo.mappers.InscriptionMapper;
import com.abouna.zekouli_bo.objet_metiers.AnneeScolaire;
import com.abouna.zekouli_bo.objet_metiers.Eleve;
import com.abouna.zekouli_bo.objet_metiers.Inscription;
import com.abouna.zekouli_bo.repositories.AnneeScolaireDao;
import com.abouna.zekouli_bo.repositories.ClasseDao;
import com.abouna.zekouli_bo.repositories.EleveDao;
import com.abouna.zekouli_bo.repositories.InscriptionDao;

@Service
public class InscriptionBusinessService extends GenericBusinessServiceImpl<Inscription, InscriptionDto, Long> {
	private final InscriptionDao dao;
	@Autowired
	private EleveDao eleveDao;
	@Autowired
	private AnneeScolaireDao anneeScolaireDao;
	private final InscriptionMapper mapper;
	@Autowired
	private ClasseDao classeDao;

	InscriptionBusinessService(InscriptionDao dao, InscriptionMapper mapper) {
		super(dao, mapper);
		this.dao = dao;
		this.mapper = mapper;
	}

	public InscriptionDto getInscriptionParAnnee(Long idAnnee, Long idEleve) {
		Optional<AnneeScolaire> annee = anneeScolaireDao.findById(idAnnee);
		Optional<Eleve> eleve = eleveDao.findById(idEleve);
		Optional<Inscription> ins = null;
		if (annee.isPresent() && eleve.isPresent()) {
			ins = dao.findByAnneeScolaireAndEleve(annee.get(), eleve.get());
			if (ins.isPresent()) {
				return mapper.convertirEnDto(ins.get());
			}
		}
		return null;
	}

	public List<InscriptionDto> getInscriptionParClasse(Long idClasse, Long idAnnee) {
		return mapper.convertirEnListeDto(dao.findByAnneeScolaireAndClasse(anneeScolaireDao.findById(idAnnee).get(),
				classeDao.findById(idClasse).get()));
	}

}
