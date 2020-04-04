package com.abouna.zekouli_ui.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
/**
 * 
 * @author abouna
 *
 */
public class FeignConfig {
	public static <T> T getFeignClient(Class<T> clazz, String url) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.registerModule(new ParameterNamesModule());
		objectMapper.registerModule(new Jdk8Module());
		objectMapper.registerModule(new JavaTimeModule());
		return Feign.builder().client(new OkHttpClient()).encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.logger(new Slf4jLogger(clazz)).logLevel(Logger.Level.FULL).target(clazz, url);
	}
}
