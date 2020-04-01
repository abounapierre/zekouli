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
public class Cycle extends ObjetMetier{
	/**
	 * 
	 */
	static final long serialVersionUID = 5658669356935350070L;
	String libelle;
	String code;
	@OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Classe> classes = new ArrayList<>();

	public void ajouter(Classe classe) {
		classes.add(classe);
		classe.setCycle(this);
	}

	public void supprimer(Classe classe) {
		classes.remove(classe);
		classe.setCycle(null);
	}
}
