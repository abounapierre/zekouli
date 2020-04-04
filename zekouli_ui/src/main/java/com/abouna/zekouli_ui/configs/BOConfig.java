package com.abouna.zekouli_ui.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author abouna
 *
 */
@Configuration
@ConfigurationProperties(prefix = "application.zekouli.bo")
public class BOConfig {
	private String schema;
	private String url;
	private String port;
	
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getUrlComplete() {
		return getSchema().concat("://").concat(getUrl()).concat(":").concat(getPort()).concat("/");
	}
}
