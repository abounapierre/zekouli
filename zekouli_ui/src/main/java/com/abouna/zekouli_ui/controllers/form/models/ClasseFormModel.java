package com.abouna.zekouli_ui.vue.dto;

import com.abouna.zekouli_ui.data.models.ClasseModel;
import com.abouna.zekouli_ui.data.models.EtablissementModel;

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
public class ClasseForm extends ClasseModel{
	/**
	 * 
	 */
	static final long serialVersionUID = -4904414151732001931L;
	EtablissementModel etablissement;

}
