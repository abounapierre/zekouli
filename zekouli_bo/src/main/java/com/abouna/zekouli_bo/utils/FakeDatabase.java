package com.abouna.zekouli_bo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_bo.business.AnneeScolaireBusinessService;
import com.abouna.zekouli_bo.business.ClasseBusinessService;
import com.abouna.zekouli_bo.business.EleveBusinessService;
import com.abouna.zekouli_bo.business.InscriptionBusinessService;
import com.abouna.zekouli_bo.data.dtos.AnneeScolaireDto;
import com.abouna.zekouli_bo.data.dtos.ClasseDto;
import com.abouna.zekouli_bo.data.dtos.EleveDto;
import com.abouna.zekouli_bo.data.dtos.EtablissementDto;
import com.abouna.zekouli_bo.data.dtos.InscriptionDto;
import com.abouna.zekouli_bo.data.dtos.TypeEtablissementDto;
import com.abouna.zekouli_bo.mappers.ClasseMapper;
import com.abouna.zekouli_bo.mappers.TypeEtablissementMapper;
import com.abouna.zekouli_bo.objet_metiers.Classe;
import com.abouna.zekouli_bo.objet_metiers.Eleve;
import com.abouna.zekouli_bo.objet_metiers.GroupeMatiere;
import com.abouna.zekouli_bo.objet_metiers.Inscription;
import com.abouna.zekouli_bo.objet_metiers.Matiere;
import com.abouna.zekouli_bo.repositories.AnneeScolaireDao;
import com.abouna.zekouli_bo.repositories.ClasseDao;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EleveDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;
import com.abouna.zekouli_bo.repositories.GroupeMatiereDao;
import com.abouna.zekouli_bo.repositories.InscriptionDao;
import com.abouna.zekouli_bo.repositories.MatiereDao;
import com.abouna.zekouli_bo.repositories.TypeEtablissementDao;

@Component
public class FakeDatabase {
	@Autowired
	private TypeEtablissementDao typeEtablissementDao;
	@Autowired
	private EtablissementDao etablissementDao;
	private TypeEtablissementMapper mapper= Mappers.getMapper(TypeEtablissementMapper.class);
	private List<EtablissementDto> etablissements;
	private List<TypeEtablissementDto> typeEtablissements;
	@Autowired
	private CycleDao cycleDao;
	@Autowired
	private GroupeMatiereDao dao;
	@Autowired
	private MatiereDao matiereDao;
	@Autowired
	private AnneeScolaireDao anneeScolaireDao;
	@Autowired
	private EleveDao eleveDao;
	@Autowired
	private InscriptionDao inscriptionDao;
	@Autowired
	private EleveBusinessService businessService;
	@Autowired
	private AnneeScolaireBusinessService anneeScolaireBusinessService;
	@Autowired
	private ClasseBusinessService classeBusinessService;
	@Autowired
	private InscriptionBusinessService inscriptionBusinessService;
	@Autowired
	private ClasseDao classeDao ;
	@Autowired
	private ClasseMapper classeMapper;

	public List<EtablissementDto> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(List<EtablissementDto> etablissements) {
		this.etablissements = etablissements;
	}

	public List<TypeEtablissementDto> getTypeEtablissements() {
		return typeEtablissements;
	}

	public void setTypeEtablissements(List<TypeEtablissementDto> typeEtablissements) {
		this.typeEtablissements = typeEtablissements;
	}

	@PostConstruct
	public void init() {		
		typeEtablissements = new ArrayList<>();
		TypeEtablissementDto t = new TypeEtablissementDto("Lycee d'enseignement general","LYGEN");
		t.setDateCreation(LocalDateTime.now());
		t.setId(1L);
		t.setDateModification(LocalDateTime.now());
		//typeEtablissementDao.save(mapper.convertirObjetMetier(t));
		typeEtablissements.add(t);
		t = new TypeEtablissementDto("Lycee d'enseignement technique","LYTECH");
		t.setDateCreation(LocalDateTime.now());
		t.setId(2L);
		t.setDateModification(LocalDateTime.now());
		typeEtablissements.add(t);
		
		//typeEtablissementDao.save(mapper.convertirObjetMetier(t));
		
		etablissements = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			i++;
			EtablissementDto e = new EtablissementDto("CETIC DE YEMKOUT " + i, "CDY" + i,
					"cetic" + i + ".yemkout@gmail.com", "www.ceticdeyemkout" + i + ".cm", null, 237698984176L + i,
					"adresse " + i ,typeEtablissements.get(0));
			e.setId(Long.valueOf(i));
			etablissements.add(e);
		}
		/*Optional<Etablissement> e = etablissementDao.findById(3L);
		if(e.isPresent()) {
			etablissementDao.deleteById(e.get().getId());
		}
		
		Optional<Cycle> cy = cycleDao.findById(6L);
		if(cy.isPresent()) {
			cycleDao.deleteById(6L);
		}*/
		
		Matiere matiere = new Matiere();
		matiere.setCode("MATSCIEN");
		matiere.setDateCreation(LocalDateTime.now());
		matiere.setDateModification(LocalDateTime.now());
		matiere.setLibelle("Matieres scientifiques");
		matiere.setUtilisateur("abouna");
		
		GroupeMatiere g = new GroupeMatiere();
		g.setCode("MATSCIEN");
		g.setDateCreation(LocalDateTime.now());
		g.setDateModification(LocalDateTime.now());
		g.setGroupeMatiereParent(null);
		g.ajouter(matiere);
		g.setLibelle("Matieres scientifiques");
		g.setUtilisateur("abouna");
		//g = dao.save(g);
		
		GroupeMatiere g1 = new GroupeMatiere();
		g1.setCode("MATSCIEN12");
		g1.setDateCreation(LocalDateTime.now());
		g1.setDateModification(LocalDateTime.now());
		g1.setGroupeMatiereParent(g);
		g1.ajouter(matiere);
		g1.setLibelle("Matieres scientifiques niveau 1");
		g1.setUtilisateur("abouna");
		//dao.save(g1);
		//save();
	}

	public EtablissementDto findByIde(Long id) {
		for(EtablissementDto model :etablissements) {
			if(id.equals(model.getId())) {
				return model;
			}
		}
		return null;
	}
	
	public EtablissementDto findByCode(String code) {
		for(EtablissementDto model :etablissements) {
			if(code.equals(model.getCode())) {
				return model;
			}
		}
		return null;
	}
	
	public EtablissementDto modifier(EtablissementDto model) {
		boolean val = false; 
		for(EtablissementDto e :etablissements) {
			if(model.getCode().equals(e.getCode())) {
				val = true;
				e.setAdresse(model.getAdresse());
				e.setCode(model.getCode());
				e.setEmail(model.getEmail());
				e.setLogo(model.getLogo());
				e.setLibelle(model.getLibelle());
				e.setSite(model.getSite());
				e.setTypeEtablissement(model.getTypeEtablissement());
				e.setTelephone(model.getTelephone());
			}
		}
		if(!val) {
			etablissements.add(model);
		}
		return model;
	}

	public void supprimer(String code) {
		for(EtablissementDto e :etablissements) {
			if(e.getCode().contentEquals(code)) {
				etablissements.remove(e);
				return;
			}
		}
	}
	
	public void save() {
		for (int i = 0; i < 100; i++) {
			i++;
			EleveDto e = new EleveDto();
			e.setNom("Eleve test " + i);
			e.setPrenom("api" + i);
			e.setLieuNaissance("Lieu" + i);
			e.setDateDeNaissance(LocalDate.now());
			//businessService.enregistrer(e);
		}
		AnneeScolaireDto anneeScolaireDto = new AnneeScolaireDto();
		anneeScolaireDto.setCode("2018-2019");
		anneeScolaireDto.setDebut(2018L);
		anneeScolaireDto.setFin(2019L);
		anneeScolaireDto.setJourDebut(LocalDate.of(2018, 9, 9));
		anneeScolaireDto.setJourFin(LocalDate.of(2019, 5, 30));
		anneeScolaireDto.setEnCours(false);
		//AnneeScolaireDto aa = anneeScolaireBusinessService.enregistrer(anneeScolaireDto);	
		int ii = 1;
		for(Eleve ee : eleveDao.findAll()) {
			Inscription inscriptionDto = new Inscription();
			inscriptionDto.setAnneeScolaire(anneeScolaireDao.findAll().get(0));
			inscriptionDto.setClasse(classeDao.findAll().get(1));
			inscriptionDto.setEleve(ee);
			inscriptionDto.setDateCreation(LocalDateTime.now());
			inscriptionDto.setDateModification(LocalDateTime.now());
			//inscriptionDao.save(inscriptionDto);
			if(ii == 20) {
				break;
			}
			ii++;
		}
		for(Inscription ins : inscriptionDao.findAll()) {
			System.out.println(ins.getId());
		}
		
	}
}
