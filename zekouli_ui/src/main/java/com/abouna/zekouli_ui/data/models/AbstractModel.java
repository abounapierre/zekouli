package com.abouna.zekouli_ui.data.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = ClasseModel.class, name = "classeModel"), 
		  @Type(value = CycleModel.class, name = "truck"),
		  @Type(value = EtablissementModel.class, name = "etablissementModel"),
		  @Type(value = NiveauModel.class, name = "niveauModel"),
		  @Type(value = SerieModel.class, name = "serieModel"),
		  @Type(value = TypeEtablissementModel.class, name = "typeEtablissementModel")
		})*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper=true,of= {"id","utilisateur","dateCreation","dateModification"})
public class AbstractModel implements Serializable{
	/**
	 * serial No.
	 */
	private static final long serialVersionUID = 1155609287296958207L;
	protected Long id;
	protected String utilisateur;
	protected String dateCreation;
	protected String dateModification;
	
	
}
