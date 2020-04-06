package com.abouna.zekouli_ui.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.controllers.form.models.EleveFormModel;
import com.abouna.zekouli_ui.data.dtos.EleveDto;
import com.abouna.zekouli_ui.data.dtos.Sexe;
import com.abouna.zekouli_ui.services.proxy.EleveProxy;

@Component
public class EleveService extends AbstractServiceImpl<EleveDto, Long> {
	@Autowired
	private MessageSource source;
	private final EleveProxy proxy;

	public EleveService(EleveProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	public EleveFormModel mapperFormulaire(EleveDto dto) {
		EleveFormModel form = new EleveFormModel();
		form.setArrondissement(dto.getArrondissement());
		form.setContact(dto.getContact());
		form.setDateCreation(dto.getDateCreation());
		form.setDateDeNaissance(dto.getDateDeNaissance());
		form.setDateModification(dto.getDateModification());
		form.setDepartement(dto.getDepartement());
		form.setDescription(dto.getDescription());
		form.setId(dto.getId());
		form.setLienPhoto(null);
		form.setLieuNaissance(dto.getLieuNaissance());
		form.setMatricule(dto.getMatricule());
		form.setNom(dto.getNom());
		form.setNomMere(dto.getNomMere());
		form.setNomPere(dto.getNomPere());
		form.setNouveau(dto.isNouveau());
		form.setPhoto(dto.getPhoto());
		form.setPrenom(dto.getPrenom());
		form.setRegion(dto.getRegion());
		form.setSexe(dto.getSexe());
		form.setStatus(dto.isNouveau() ? source.getMessage("application_status_nouveau_libelle", null, null)
				: source.getMessage("application_status_ancien_libelle", null, null));
		form.setLibelleSexe(
				dto.getSexe() == Sexe.FEMININ ? source.getMessage("application_sexe_libelle_feminin", null, null)
						: source.getMessage("application_sexe_libelle_masculin", null, null));
		form.setUtilisateur(dto.getUtilisateur());
		return form;
	}

	public EleveFormModel enregistrer(EleveFormModel form, Long id) {
		EleveDto dto = (EleveDto) form;
		dto.setSexe(getSexe(form.getLibelleSexe()));
		dto.setNouveau(
				source.getMessage("application_status_nouveau_libelle", null, null).contentEquals(form.getStatus())
						? true
						: false);
		return mapperFormulaire(enregistrerOuModifier(dto, id));
	}

	private Sexe getSexe(String valeur) {
		if (source.getMessage("application_sexe_libelle_masculin", null, null).contentEquals(valeur)) {
			return Sexe.MASCULIN;
		} else if (source.getMessage("application_sexe_libelle_feminin", null, null).contentEquals(valeur)) {
			return Sexe.FEMININ;
		}
		return null;
	}

	public List<EleveDto> getListeParMatriculeOuNom(String matricule, String nom) {
		return proxy.getListeParMatriculeOuNom(matricule, nom);
	}

}
