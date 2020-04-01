package com.abouna.zekouli_bo.objet_metiers;

import java.util.HashSet;
import java.util.Set;

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
public class Serie extends ObjetMetier{
	/**
	 * 
	 */
	static final long serialVersionUID = 4728727538062979835L;
	String libelle;
	String code;
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Classe> classes = new HashSet<Classe>();
	
	public void ajouter(Classe classe) {
		classes.add(classe);
		classe.setSerie(this);
	}

	public void supprimer(Classe classe) {
		classes.remove(classe);
		classe.setSerie(null);
	}
}
