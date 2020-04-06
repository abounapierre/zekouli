package com.abouna.zekouli_ui.controllers.form.models;

import java.util.List;

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
public class EleveFormModel extends EleveDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7575738158566771644L;
	List<String> contacts;
	String lienPhoto;
	String status;
	String libelleSexe;
}
