package com.abouna.zekouli_ui.controllers.form.models;

public class MessageForm {
	private String message;
	private String type;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MessageForm(String message, String type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	
}
