package com.abouna.zekouli_ui.controllers.form.models;

import com.abouna.zekouli_ui.data.dtos.EtablissementDto;
import com.abouna.zekouli_ui.data.dtos.MatiereDto;

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
@EqualsAndHashCode(callSuper=false,of= {"etablissement"})
@ToString(callSuper=true,of= {"etablissement"})
public class MatiereFormModel extends MatiereDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 254693737067655807L;
	EtablissementDto etablissement;

}
