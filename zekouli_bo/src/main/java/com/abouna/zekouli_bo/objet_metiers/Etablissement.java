package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","typeEtablissement"})
@ToString(of= {"libelle","code"})
public class Etablissement extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = -3175637138376895044L;
	@Column(nullable = false)
	String libelle;
	@Column(nullable = false)
	String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_etablissement",nullable = true)
	TypeEtablissement typeEtablissement;
	@Email
	String email;
	String site;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	byte[] logo;
	Long telephone;
	String adresse;
	@OneToMany(mappedBy = "etablissement")
	List<Cycle> cycles = new ArrayList<>();
	@OneToMany(mappedBy = "etablissement")
	List<Serie> series = new ArrayList<>();
	@OneToMany(mappedBy = "etablissement")
	List<Niveau> niveaux = new ArrayList<>();
	
	public void ajouter(Serie serie) {
		series.add(serie);
		serie.setEtablissement(this);
	}

	public void supprimer(Serie serie) {
		series.remove(serie);
		serie.setEtablissement(null);
	}
	
	public void ajouter(Cycle cycle) {
		cycles.add(cycle);
		cycle.setEtablissement(this);
	}

	public void supprimer(Cycle cycle) {
		cycles.remove(cycle);
		cycle.setEtablissement(null);
	}
	
	public void ajouter(Niveau niveau) {
		niveaux.add(niveau);
		niveau.setEtablissement(this);
	}

	public void supprimer(Niveau niveau) {
		niveaux.remove(niveau);
		niveau.setEtablissement(null);
	}

}
