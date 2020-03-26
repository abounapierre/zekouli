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
public class HomeController {
    
    @GetMapping("/plain_page")
    public String plainPage(){
        return "plain_page";
    }
    
    
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user-profil", "/images/img.jpg");
        return "home";
    }
    
    @GetMapping("/princing-tables")
    public String princingTables(){
        return "princing-tables";
    }
    
     @GetMapping("/home")
    public String getHome(){
        return "home";
    }
    
    @GetMapping("/ecole")
    public String getEcole(){
        return "parametre/ecole";
    }
    
    
    /* @GetMapping("/princing-tables")
    public String princingTables(){
        return "princing-tables";
    }*/
    
}
