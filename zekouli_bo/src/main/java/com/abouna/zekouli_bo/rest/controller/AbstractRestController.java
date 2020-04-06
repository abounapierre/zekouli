package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abouna.zekouli_bo.data.dtos.AbstractDto;

import io.swagger.annotations.ApiOperation;

public interface AbstractRestController <R extends AbstractDto, ID extends Object>{
	@ApiOperation(value = "permet l'enregistrement d'un objet metier à partir de son dto")
	@PostMapping
	public R enregistrer(@RequestBody R r);

	@ApiOperation(value = "permet la modification d'un objet métier à partir de son dto")
	@PutMapping("/{id}")
	public R modifier(@RequestBody R r,@PathVariable ID id);
	
	@ApiOperation(value = "Récupère un objet métier partir de son id")
	@GetMapping("/{id}")
	public R getParId(@PathVariable ID id);
	
	@ApiOperation(value = "Récupère la liste des objets metiers")
	@GetMapping
	public List<R> getliste();
	
	@ApiOperation(value = "Supprime un objet metier à partir de son id")
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable ID id) ;
}
