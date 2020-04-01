package com.abouna.zekouli_bo.objet_metiers;

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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","etablissement"})
@ToString(of= {"libelle","code"})
public class Classe extends ObjetMetier{
	/**
	 * s version.
	 */
	static final long serialVersionUID = 6608513388037821077L;
	String libelle;
	String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_etablissement")
	Etablissement etablissement;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cycle")
	Cycle cycle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_niveau")
	Niveau niveau;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_serie")
	Serie serie;

}