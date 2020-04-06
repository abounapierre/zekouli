package com.abouna.zekouli_bo.objet_metiers;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Montant extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = -2939467024612588143L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_paiement")
	TypePaiement typePaiement;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_annee_scolaire")
	AnneeScolaire anneeScolaire;
	BigDecimal valeur;
}
