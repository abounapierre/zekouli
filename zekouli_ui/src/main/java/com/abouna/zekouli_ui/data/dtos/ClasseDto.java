package com.abouna.zekouli_ui.data.dtos;

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
@ToString(callSuper=true,of= {"libelle","code"})
public class ClasseDto extends AbstractDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7161326317628975545L;
	String libelle;
	String code;
	CycleDto cycle;
	NiveauDto niveau;
	SerieDto serie;
	
}
