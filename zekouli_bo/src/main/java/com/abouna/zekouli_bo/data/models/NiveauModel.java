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
public class NiveauModel extends AbstractModel{
	/**
	 * serial number.
	 */
	static final long serialVersionUID = -6917561774096989422L;
	String libelle;
	String code;
	EtablissementModel etablissement;
	CycleModel cycle;

}
