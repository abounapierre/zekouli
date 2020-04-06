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
public class GroupeMatiereDto extends AbstractDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4363555502471574948L;
	String code;
	String libelle;
	GroupeMatiereDto groupeMatiereParent;
}
