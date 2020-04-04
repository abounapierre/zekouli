package com.abouna.zekouli_ui.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.abouna.zekouli_ui.data.dtos.AbstractDto;

public abstract class AbstractController<T extends AbstractDto> {
	public abstract String getTemplate(Model model);
	protected abstract boolean validerFormulaire(T dto, Model model);
}
