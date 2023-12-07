package fr.morgan.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.morgan.bll.ProjetService;

@Controller
@RequestMapping("/projets")
public class ProjetController {

	@Autowired
	ProjetService projetService;
	
	@GetMapping
	public String listeProjets(Model model) {
		model.addAttribute("projets",projetService.getProjets());
		return "projets";
	}
	
	@GetMapping("/detail/{id}")
	public String detailProjet(@PathVariable(name="id") long id,Model model) {
		model.addAttribute("projet", projetService.getProjet(id));
		return "detailprojet";
	}
	
}
