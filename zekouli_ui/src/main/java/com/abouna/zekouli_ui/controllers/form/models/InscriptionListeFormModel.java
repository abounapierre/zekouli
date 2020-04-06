package com.abouna.zekouli_ui.controllers.form.models;

import java.util.List;

import com.abouna.zekouli_ui.data.dtos.AnneeScolaireDto;
import com.abouna.zekouli_ui.data.dtos.ClasseDto;
import com.abouna.zekouli_ui.data.dtos.EleveDto;

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
public class InscriptionListeFormModel {
	List<EleveDto> eleveInscrits;
	ClasseDto classe;
	AnneeScolaireDto anneeScolaire;
	
}
