package com.abouna.zekouli_bo.utils;

public class RequeteUtils {
	public static final String REQUETE_ELEVE_INSCRITS = "(SELECT DISTINCT new com.abouna.zekouli_bo.data.dtos.EleveNonInscritDto(e.id, e.nom, e.prenom, e.matricule, a.code) FROM Eleve e, Inscription i, AnneeScolaire a) EXCEPT (SELECT DISTINCT new com.abouna.zekouli_bo.data.dtos.EleveNonInscritDto(e.id, e.nom, e.prenom, e.matricule, a.code) "
			+ "FROM Eleve e, Inscription i, AnneeScolaire a WHERE i.eleve = e AND i.anneeScolaire = a AND a = :anneeScolaire)";
}
