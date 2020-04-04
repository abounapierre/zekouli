package com.abouna.zekouli_bo.objet_metiers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
@EqualsAndHashCode(callSuper=false,of= {"libelle","code"})
@ToString(of= {"libelle","code"})
public class Trimestre extends ObjetMetier{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3292790695874615339L;
	@Column(nullable = false)
	String libelle;
	@Column(nullable = false)
	String code;
	@OneToMany(mappedBy = "trimestre")
	List<Sequence> sequences = new ArrayList<>();
	
	public void ajouter(Sequence sequence) {
		sequences.add(sequence);
		sequence.setTrimestre(this);
	}

	public void supprimer(Sequence sequence) {
		sequences.remove(sequence);
		sequence.setTrimestre(null);
	}
}
