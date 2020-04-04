package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
@ToString(callSuper=true,of= {"libelle","code","etablissement"})
public class Serie extends ObjetMetier{
	/**
	 * 
	 */
	static final long serialVersionUID = 4728727538062979835L;
	@Column(nullable = false)
	String libelle;
	@Column(nullable = false)
	String code;
	@OneToMany(mappedBy = "serie")
	Set<Classe> classes = new HashSet<Classe>();
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	Etablissement etablissement;
	@OneToMany(mappedBy = "serie")
	List<Matiere> matieres = new ArrayList<>();
	
	public void ajouter(Classe classe) {
		classes.add(classe);
		classe.setSerie(this);
	}

	public void supprimer(Classe classe) {
		classes.remove(classe);
		classe.setSerie(null);
	}
	
	public void ajouter(Matiere matiere) {
		matieres.add(matiere);
		matiere.setSerie(this);
	}

	public void supprimer(Matiere matiere) {
		matieres.remove(matiere);
		matiere.setSerie(null);
	}
}
