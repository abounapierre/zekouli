package com.abouna.zekouli_ui.data.models;

import java.io.Serializable;

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
@EqualsAndHashCode(of= {"nom"})
@ToString(of= {"nom","id"})
public class TypeEtablissementModel implements Serializable{
	/**
	 * 
	 */
	static final long serialVersionUID = 1051860772081040152L;
	String nom;
	Integer id;
}
