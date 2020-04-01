package com.abouna.zekouli_bo.data.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"libelle","code"})
@ToString(callSuper=true,of= {"libelle","code","email","site"})
public class EtablissementModel extends AbstractModel{
	/**
	 * serial number.
	 */
	static final long serialVersionUID = 2653318469846302778L;
	@NotNull
	String libelle;
	@NotNull
	String code;
	@Email
	String email;
	String site;
	byte[] logo;
	Long telephone;
	String adresse;
	TypeEtablissementModel typeEtablissement;
	
}
