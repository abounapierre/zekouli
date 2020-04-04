/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abouna.zekouli_ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author abouna
 */
@Controller
public class HomeController{   
    
    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("user-profil", "/images/img.jpg");
        return "home";
    }
    

	@GetMapping("/")
	public String getTemplate(Model model) {
		return "home";
	}
      
    
}
