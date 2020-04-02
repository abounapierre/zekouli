package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Column;
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
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"debut","code","fin"})
@ToString(callSuper=true,of= {"debut","code","fin","enCours"})
public class AnneeScolaire extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = -2911831734120452574L;
	@Column(nullable = false)
	Long debut;
	@Column(nullable = false)
	Long fin;
	@Column(nullable = false)
	String code;
	boolean enCours;

}