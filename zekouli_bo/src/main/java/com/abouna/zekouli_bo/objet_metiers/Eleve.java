package com.abouna.zekouli_bo.objet_metiers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
/**
 * 
 * @author abouna
 *
 */
@Entity
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"nom","dateDeNaissance"})
@ToString(of= {"nom","prenom","sexe"})
public class Eleve extends ObjetMetier{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6085956894539915029L;
	@Column(nullable = false)
	String nom;
	String prenom;
	Sexe sexe;
	@Column(nullable = false, unique = true)
	String matricule;
	String nomPere;
	String nomMere;
	String contact;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate dateDeNaissance;
	String lieuNaissance;
	String departement;
	String region;
	String arrondissement;
	String description;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	byte[] photo;
	boolean nouveau;
	@OneToMany(mappedBy = "eleve")
	List<Inscription> inscriptions = new ArrayList<>();
	
	public void ajouter(Inscription inscription) {
		inscriptions.add(inscription);
		inscription.setEleve(this);
	}

	public void supprimer(Inscription inscription) {
		inscriptions.remove(inscription);
		inscription.setEleve(null);
	}
	
}
