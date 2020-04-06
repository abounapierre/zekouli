package com.abouna.zekouli_ui.controllers.form.models;

public class SexeModel {
	private String code;
	private String libelle;
	
	
	public SexeModel(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
