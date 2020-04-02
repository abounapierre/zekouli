package com.abouna.zekouli_bo.objet_metiers;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class ObjetMetier implements Serializable{
	/**
	 * serial number.
	 */
	static final long serialVersionUID = -6776459278328090828L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(name = "utilisateur")
	String utilisateur;
	@Column(name = "date_creation")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	protected LocalDateTime dateCreation;
	@Column(name = "date_modification")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	protected LocalDateTime dateModification;
	
}
