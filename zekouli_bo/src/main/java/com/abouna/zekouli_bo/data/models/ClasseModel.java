package com.abouna.zekouli_bo.data.models;

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
@ToString(of= {"libelle","code"})
public class ClasseModel extends AbstractModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7161326317628975545L;
	String libelle;
	String code;
	EtablissementModel etablissement;
	CycleModel cycle;
	NiveauModel niveau;
	SerieModel serie;
	
}
