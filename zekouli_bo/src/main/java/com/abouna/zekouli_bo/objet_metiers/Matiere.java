package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","groupeMatiere"})
@ToString(of= {"libelle","code","groupeMatiere"})
public class Matiere extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = 6769959278323616662L;
	@Column(nullable = false)
	String libelle;
	@Column(nullable = false)
	String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_groupe_matiere",nullable = true)
	GroupeMatiere groupeMatiere;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_niveau",nullable = true)
	Niveau niveau;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_serie",nullable = true)
	Serie serie;

}
