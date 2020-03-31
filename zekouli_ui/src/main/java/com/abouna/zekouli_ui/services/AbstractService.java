package com.abouna.zekouli_ui.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.abouna.zekouli_ui.configs.BOConfig;


public class AbstractService {
	@Autowired
	private BOConfig boConfig;
	
	public String getSchema() {
		return boConfig.getSchema();
	}
	
	public String getUrl() {
		return boConfig.getUrl();
	}
	
	public String getPort() {
		return boConfig.getPort();
	}
}
