package com.abouna.zekouli_ui.data.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"libelle","code"})
@ToString(callSuper=true,of= {"libelle","code"})
public class TypeEtablissementModel extends AbstractModel{
	/**
	 * 
	 */
	static final long serialVersionUID = 1051860772081040152L;
	String libelle;
	String code;
	
	/*@Builder
	public TypeEtablissementModel(Long id, String utilisateur, String dateCreation, String dateModification,String libelle,String code) {
		super(id, utilisateur, dateCreation, dateModification);
		this.libelle =libelle ;
		this.code = code;
	}*/
	
	
}
