package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "libelle", "code", "groupeMatiereParent" })
@ToString(of = { "libelle", "code", "groupeMatiereParent" })
public class GroupeMatiere extends ObjetMetier {
	/**
	 * 
	 */
	static final long serialVersionUID = -8740105286124039302L;
	@Column(nullable = true)
	String code;
	@Column(nullable = true)
	String libelle;
	@OneToMany(mappedBy = "groupeMatiereParent")
	Set<GroupeMatiere> sousGroupeMatieres = new HashSet<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id", name = "id_groupe_matiere_parent")
	@JsonBackReference
	GroupeMatiere groupeMatiereParent;
	@OneToMany(mappedBy = "groupeMatiere")
	List<Matiere> matieres = new ArrayList<>();

	public void ajouter(GroupeMatiere groupeMatiereParent) {
		sousGroupeMatieres.add(groupeMatiereParent);
		groupeMatiereParent.setGroupeMatiereParent(this);
	}

	public void supprimer(GroupeMatiere groupeMariereParent) {
		sousGroupeMatieres.remove(groupeMatiereParent);
		groupeMatiereParent.setGroupeMatiereParent(null);
	}

	public void ajouter(Matiere matiere) {
		matieres.add(matiere);
		matiere.setGroupeMatiere(this);
	}

	public void supprimer(Matiere matiere) {
		matieres.remove(matiere);
		matiere.setGroupeMatiere(null);
	}
}
