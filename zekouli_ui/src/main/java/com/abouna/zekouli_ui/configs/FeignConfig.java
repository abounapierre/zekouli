package com.abouna.zekouli_ui.configs;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignConfig {
	
	public static <T> T getFeignClient(Class<T> clazz,String url) {
		return Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(clazz))
				  .logLevel(Logger.Level.FULL)
				  .target(clazz, url);
	}
}
