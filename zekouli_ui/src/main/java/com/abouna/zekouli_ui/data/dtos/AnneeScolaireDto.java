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
@EqualsAndHashCode(callSuper=false,of= {"debut","code","fin"})
@ToString(of= {"debut","code","fin","enCours"})
public class AnneeScolaireModel extends AbstractModel{
	/**
	 * 
	 */
	static final long serialVersionUID = 1277024681662039495L;
	String code;
	Long debut;
	Long fin;
	boolean enCours;
}
