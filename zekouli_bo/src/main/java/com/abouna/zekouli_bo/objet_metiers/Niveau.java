package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Niveau extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = 2652385460101592830L;
	String libelle;
	String code;
	@OneToMany(mappedBy = "niveau", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Classe> classes = new ArrayList<Classe>();
	
	public void ajouter(Classe classe) {
		classes.add(classe);
		classe.setNiveau(this);
	}

	public void supprimer(Classe classe) {
		classes.remove(classe);
		classe.setNiveau(null);
	}

}
