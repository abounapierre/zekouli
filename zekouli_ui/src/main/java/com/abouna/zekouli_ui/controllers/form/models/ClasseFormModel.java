package com.abouna.zekouli_ui.controllers.form.models;

import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.data.dtos.EtablissementDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClasseFormModel extends ClasseDto{
	/**
	 * 
	 */
	static final long serialVersionUID = -4904414151732001931L;
	EtablissementDto etablissement;

}
