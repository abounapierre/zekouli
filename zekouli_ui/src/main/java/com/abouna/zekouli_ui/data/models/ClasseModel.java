package com.abouna.zekouli_ui.data.models;

import java.io.Serializable;

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
@EqualsAndHashCode(of= {"libelle","code"})
@ToString(of= {"libelle","code"})
public class ClasseModel implements Serializable{
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
