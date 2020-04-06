package com.abouna.zekouli_ui.controllers.form.models;

import com.abouna.zekouli_ui.data.dtos.ClasseDto;
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
public class InscriptionFormulaireRecherche {
	ClasseDto classe;
	
}
