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
@EqualsAndHashCode(callSuper=false,of= {"anneeScolaire","eleve","classe"})
@ToString(of= {"anneeScolaire","eleve","classe"})
public class InscriptionDto extends AbstractDto{
	/**
	 * 
	 */
	static final long serialVersionUID = -211469090155371693L;
	AnneeScolaireDto anneeScolaire;
	EleveDto eleve;
	ClasseDto classe;
}
