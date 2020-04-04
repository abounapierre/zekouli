package com.abouna.zekouli_bo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abouna.zekouli_bo.data.models.AbstractDto;

public interface AbstractRestController <R extends AbstractDto, ID extends Object>{
	@PostMapping
	public R enregistrer(@RequestBody R r);

	@PutMapping("/{id}")
	public R modifier(@RequestBody R r,@PathVariable ID id);
	
	@GetMapping("/{id}")
	public R getParId(@PathVariable ID id);
	
	@GetMapping
	public List<R> getliste();
	
	@DeleteMapping("/{id}")
	public void supprimer(@PathVariable ID id) ;
}
