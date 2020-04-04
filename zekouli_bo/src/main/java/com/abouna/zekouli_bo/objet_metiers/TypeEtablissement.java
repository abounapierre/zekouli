package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "libelle", "code" })
@ToString(of = { "libelle", "code" })
public class TypeEtablissement extends ObjetMetier {

	/**
	 * 
	 */
	static final long serialVersionUID = 8767542948297640288L;
	@Column(nullable = false)
	String libelle;
	@Column(nullable = false)
	String code;
	@OneToMany(mappedBy = "typeEtablissement")//, cascade = CascadeType.ALL, orphanRemoval = true
	List<Etablissement> etablissements = new ArrayList<>();

	public void ajouter(Etablissement etablissement) {
		etablissements.add(etablissement);
		etablissement.setTypeEtablissement(this);
	}

	public void supprimer(Etablissement etablissement) {
		etablissements.remove(etablissement);
		etablissement.setTypeEtablissement(null);
	}

}
