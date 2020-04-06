package com.abouna.zekouli_bo.objet_metiers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false,of= {"debut","code","fin"})
@ToString(callSuper=true,of= {"debut","code","fin","enCours"})
public class AnneeScolaire extends ObjetMetier{

	/**
	 * 
	 */
	static final long serialVersionUID = -2911831734120452574L;
	@Column(nullable = false)
	Long debut;
	@Column(nullable = false)
	Long fin;
	@Column(nullable = false,unique = true)
	String code;
	boolean enCours;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate jourDebut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate jourFin;
	@OneToMany(mappedBy = "anneeScolaire")
	List<Inscription> inscriptions = new ArrayList<>();
	
	public void ajouter(Inscription inscription) {
		inscriptions.add(inscription);
		inscription.setAnneeScolaire(this);
	}

	public void supprimer(Inscription inscription) {
		inscriptions.remove(inscription);
		inscription.setAnneeScolaire(null);
	}
	
}
