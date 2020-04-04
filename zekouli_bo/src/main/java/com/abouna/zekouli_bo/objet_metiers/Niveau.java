package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","etablissement"})
@ToString(of= {"libelle","code","etablissement"})
public class Niveau extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = 2652385460101592830L;
	String libelle;
	String code;
	@OneToMany(mappedBy = "niveau")
	List<Classe> classes = new ArrayList<Classe>();
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	Etablissement etablissement;
	@ManyToOne
	@JoinColumn(name = "id_cycle")
	Cycle cycle;
	@OneToMany(mappedBy = "niveau")
	List<Matiere> matieres = new ArrayList<>();
	
	public void ajouter(Classe classe) {
		classes.add(classe);
		classe.setNiveau(this);
	}

	public void supprimer(Classe classe) {
		classes.remove(classe);
		classe.setNiveau(null);
	}
	
	public void ajouter(Matiere matiere) {
		matieres.add(matiere);
		matiere.setNiveau(this);
	}

	public void supprimer(Matiere matiere) {
		matieres.remove(matiere);
		matiere.setNiveau(null);
	}

}
