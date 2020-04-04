package com.abouna.zekouli_ui.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.abouna.zekouli_ui.data.dtos.AbstractDto;

public abstract class AbstractPageController<T extends AbstractDto,ID extends Object> {
	@GetMapping
	public abstract String getTemplate(Model model);
	protected abstract boolean validerFormulaire(T dto, Model model);
	@PostMapping("/enregistrer")
	public abstract String enregistre(T dto,
			BindingResult result, Model model);
	@GetMapping("/modifier/{id}")
	public abstract String chargerFormulaire(ID id, Model model);
	@GetMapping("/supprimer/{id}")
	public abstract String supprimer(ID id, Model model);
	@GetMapping("/annuler")
	public abstract String initialiserFormulaire(Model model);
}
