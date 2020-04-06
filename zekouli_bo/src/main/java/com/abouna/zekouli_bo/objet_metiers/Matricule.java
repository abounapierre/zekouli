package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@EqualsAndHashCode(callSuper=false,of= {"valeur"})
@ToString(of= {"valeur"})
public class Matricule extends ObjetMetier{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8211539564271871313L;
	@Column(nullable = false, unique = true)
	String valeur;
}
