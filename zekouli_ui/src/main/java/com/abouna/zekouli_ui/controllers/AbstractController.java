package com.abouna.zekouli_ui.controllers;

import org.springframework.ui.Model;

public abstract class AbstractController {
	public abstract String getTemplate(Model model);
}
