package com.abouna.zekouli_ui.data.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@ToString(of= {"nom","prenom","matricule","annee"})
public class EleveInscritDto {
	Long id;
	String nom;
	String prenom;
	String matricule;
	String annee;
	String classe;
}
