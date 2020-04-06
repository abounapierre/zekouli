package com.abouna.zekouli_bo.data.dtos;

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
public class MatiereDto extends AbstractDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3065121329411666898L;
	String libelle;
	String code;
	SerieDto serie;
	NiveauDto niveau;
	GroupeMatiereDto groupeMatiere;
}
