package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id_eleve","id_annee_scolaire"}))
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inscription extends ObjetMetier{
	/**
	 * 
	 */
	static final long serialVersionUID = -5472198821854124375L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_annee_scolaire")
	AnneeScolaire anneeScolaire;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_eleve")
	Eleve eleve;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_classe")
	@Fetch(FetchMode.JOIN)
	Classe classe;
}
