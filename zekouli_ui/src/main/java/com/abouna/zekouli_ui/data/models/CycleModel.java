package com.abouna.zekouli_ui.data.models;

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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","etablissement"})
@ToString(callSuper=true,of= {"libelle","code","etablissement"})
public class CycleModel extends AbstractModel{
	/**
	 * 
	 */
	static final long serialVersionUID = -5688558945088143316L;
	String libelle;
	String code;
	EtablissementModel etablissement;

}
