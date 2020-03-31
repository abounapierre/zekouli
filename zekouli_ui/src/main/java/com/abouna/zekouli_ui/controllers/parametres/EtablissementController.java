package com.abouna.zekouli_ui.controllers.parametres;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abouna.zekouli_ui.controllers.AbstractController;
import com.abouna.zekouli_ui.data.models.EtablissementModel;
import com.abouna.zekouli_ui.utils.FakeDatabase;

@Controller
public class EtablissementController extends AbstractController {
	@Autowired
	private FakeDatabase fakeDatabase;

	@Override
	@GetMapping("/etablissement")
	public String getTemplate(Model model) {
			model.addAttribute("etablissements", fakeDatabase.getEtablissements());
			model.addAttribute("typeEtablissements", fakeDatabase.getTypeEtablissements());
		model.addAttribute("etablissementModel", new EtablissementModel());
		return "parametre/etablissement";
	}

	
	@PostMapping("/etablissement/enregister")
	public String enregistre(@ModelAttribute("etablissementModel") @Valid EtablissementModel etablissementModel,BindingResult result,Model model) {
		if(!result.hasErrors() && etablissementModel.getCode()!=null && etablissementModel.getNom()!=null && etablissementModel.getTypeEtablissement()!=null) {
			fakeDatabase.modifier(etablissementModel);
			model.addAttribute("message", "success");
		}
		model.addAttribute("etablissements", fakeDatabase.getEtablissements());
		model.addAttribute("typeEtablissements", fakeDatabase.getTypeEtablissements());
		return "parametre/etablissement";
	}
	
	@GetMapping("/etablissement/modifier/{code}")
    public String showUpdateForm(@PathVariable("code") String code, Model model) {
		EtablissementModel etablissementModel = fakeDatabase.findByCode(code)/*.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + code))*/;
        if(etablissementModel != null) {
        	model.addAttribute("etablissementModel", etablissementModel);
        }
        model.addAttribute("etablissements", fakeDatabase.getEtablissements());
		model.addAttribute("typeEtablissements", fakeDatabase.getTypeEtablissements());
        return "parametre/etablissement";
    }
	
	@GetMapping("/etablissement/supprimer/{code}")
    public String supprimer(@PathVariable("code") String code, Model model) {
		fakeDatabase.supprimer(code);
        model.addAttribute("etablissements", fakeDatabase.getEtablissements());
		model.addAttribute("typeEtablissements", fakeDatabase.getTypeEtablissements());
		model.addAttribute("etablissementModel", new EtablissementModel());
        return "parametre/etablissement";
    }
	
	@GetMapping("/etablissement/annuler")
	public String initialiserFormulaire(Model model) {
		model.addAttribute("etablissementModel", new EtablissementModel());
		model.addAttribute("typeEtablissements", fakeDatabase.getTypeEtablissements());
		 model.addAttribute("etablissements", fakeDatabase.getEtablissements());
		return "parametre/etablissement";
	}

}
