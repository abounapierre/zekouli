package com.abouna.zekouli_bo.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.abouna.zekouli_bo.data.models.CycleModel;
import com.abouna.zekouli_bo.mappers.CycleMapper;
import com.abouna.zekouli_bo.objet_metiers.Cycle;
import com.abouna.zekouli_bo.objet_metiers.Etablissement;
import com.abouna.zekouli_bo.repositories.CycleDao;
import com.abouna.zekouli_bo.repositories.EtablissementDao;

@Service
public class CycleBusinessService {
	@Autowired
	private CycleDao cycleDao;
	@Autowired
	private EtablissementDao etablissementDao;
	private CycleMapper mapper= Mappers.getMapper(CycleMapper.class);

	public CycleModel enregistrer(CycleModel cycleModel) {
		Cycle c = mapper.destinationToSource(cycleModel);
		c.setDateCreation(LocalDateTime.now());
		c.setDateModification(LocalDateTime.now());
		c = cycleDao.save(c);
		return mapper.sourceToDestination(c);
	}

	public CycleModel modifier(CycleModel cycleModel, Long id) {
		Optional<Cycle> et = cycleDao.findById(id);
		Cycle e = mapper.destinationToSource(cycleModel);
		if(et.isPresent()) {
			e.setId(et.get().getId());
			e.setDateCreation(et.get().getDateCreation());
			e.setDateModification(LocalDateTime.now());
			e = cycleDao.save(e);
			return mapper.sourceToDestination(e);
		}
		return null;
	}

	public CycleModel getParId(@PathVariable Long id) {
		Optional<Cycle> e = cycleDao.findById(id);
		return e.isPresent() == true ? mapper.sourceToDestination(e.get()) : null;
	}
	
	public List<CycleModel> getliste(){
		return mapper.toCycleModelList(cycleDao.findAll());
	}
	
	public void supprimer(@PathVariable Long id) {
		cycleDao.deleteById(id);
	}
	
	public List<CycleModel> getListeParEtablissement(Long id){
		Optional<Etablissement> e = etablissementDao.findById(id);
		if(e.isPresent()) {
			return mapper.toCycleModelList(cycleDao.findByEtablissement(e.get()));
		}
		return  null;
	}

}
