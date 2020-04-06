package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Entity;

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
public class TypePaiement extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = -8667511368200461099L;
	String code;
	String libelle;
	Etablissement etablissement;

}
