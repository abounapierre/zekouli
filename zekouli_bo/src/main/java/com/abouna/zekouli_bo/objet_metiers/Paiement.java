package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paiement extends ObjetMetier{
	/**
	 * 
	 */
	static final long serialVersionUID = 8345423786289031014L;
	Eleve eleve;
	Montant montant;
	AnneeScolaire anneeScolaire;
}
