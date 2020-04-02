package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.List;

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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code"})
@ToString(of= {"libelle","code"})
public class Cycle extends ObjetMetier{
	/**
	 * 
	 */
	static final long serialVersionUID = 5658669356935350070L;
	@Column(nullable = false)
	String libelle;
	@Column(nullable = false)
	String code;
	@OneToMany(mappedBy = "cycle")
	List<Classe> classes = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_etablissement",nullable = false)
	Etablissement etablissement;
	@OneToMany(mappedBy = "cycle")
	List<Niveau> niveaux = new ArrayList<>();

	public void ajouter(Classe classe) {
		classes.add(classe);
		classe.setCycle(this);
	}

	public void supprimer(Classe classe) {
		classes.remove(classe);
		classe.setCycle(null);
	}
	
	public void ajouter(Niveau o) {
		niveaux.add(o);
		o.setCycle(this);
	}

	public void supprimer(Niveau o) {
		niveaux.remove(o);
		o.setCycle(null);
	}
}
