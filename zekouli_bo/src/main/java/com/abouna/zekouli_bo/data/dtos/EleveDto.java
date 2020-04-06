package com.abouna.zekouli_bo.data.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.abouna.zekouli_bo.objet_metiers.Sexe;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

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
@ToString(of= {"nom","prenom","matricule","sexe"})
public class EleveDto extends AbstractDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4132200688040828299L;
	String nom;
	String prenom;
	Sexe sexe;
	String matricule;
	String nomPere;
	String nomMere;
	String contact;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate dateDeNaissance;
	String lieuNaissance;
	String departement;
	String region;
	String arrondissement;
	String description;
	byte[] photo;
	boolean nouveau;

}
