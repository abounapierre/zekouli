package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * 
 * @author abouna
 *
 */
@Entity
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","trimestre"})
@ToString(of= {"libelle","code","trimestre"})
public class Sequence extends ObjetMetier{
	/**
	 * version.
	 */
	static final long serialVersionUID = 667285412497439864L;
	String libelle;
	String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_trimestre")
	Trimestre trimestre;
}
