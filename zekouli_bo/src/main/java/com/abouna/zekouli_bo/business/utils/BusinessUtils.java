package com.abouna.zekouli_bo.business.utils;

import java.time.LocalDate;

public class BusinessUtils {
	
	public static String getMatricule(Integer rang) {
		LocalDate date =  LocalDate.now();
		String annee = Integer.toString(date.getYear());
		if(rang < 10) {
			return  annee.substring(annee.length()-2)+ "M000" + rang;
		} else if( rang < 100 && rang >= 10) {
			return  annee.substring(annee.length()-2)+ "M00" + rang;
		}else if(rang >= 100 && rang < 1000){
			return  annee.substring(annee.length()-2)+ "M0" + rang;
		}else {
			return  annee.substring(annee.length()-2)+ "M" + rang;
		}
		
	}
}
