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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code","trimestre"})
@ToString(of= {"libelle","code","trimestre"})
public class SequenceDto extends AbstractDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5087985469433603387L;
	String libelle;
	String code;
	TrimestreDto trimestre;
}
