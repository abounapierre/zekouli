package com.abouna.zekouli_bo.objet_metiers;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

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
@EqualsAndHashCode(callSuper=false,of= {"nom","code","typeEtablissement"})
@ToString(of= {"nom","code"})
public class Etablissement extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = -3175637138376895044L;
	String nom;
	String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_etablissement")
	TypeEtablissement typeEtablissement;
	@Email
	String email;
	String site;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	byte[] logo;
	Long telephone;
	String adresse;

}
