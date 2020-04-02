package com.abouna.zekouli_ui.services.proxy;

import java.util.List;

import com.abouna.zekouli_ui.data.models.AbstractModel;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface AbstractProxy<T extends AbstractModel,ID extends Object> {
	@RequestLine("GET /{id}")
    T getParId(@Param("id") ID id);
 
    @RequestLine("GET")
    List<T> getList();
 
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    T enregistrer(T t);
    
    @RequestLine("PUT /{id}")
    @Headers("Content-Type: application/json")
    T modifier(T t,@Param("id") ID id);
    
    @RequestLine("DELETE /{id}")
    void supprimer(@Param("id") ID id);
}
