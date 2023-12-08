package fr.morgan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.morgan.bll.EmployeService;
import fr.morgan.bll.ProjetService;
import fr.morgan.bo.Employe;
import fr.morgan.bo.Projet;

@Controller
@RequestMapping("/projets")
public class ProjetController {

	@Autowired
	ProjetService projetService;

	@Autowired
	EmployeService employeService;

	@GetMapping
	public String listeProjets(Model model) {
		model.addAttribute("projets", projetService.getProjets());
		model.addAttribute("employes", employeService.getEmployes());
		return "projets";
	}

	@GetMapping("/detail/{id}")
	public String detailProjet(@PathVariable(name = "id") long id, Model model) {
		model.addAttribute("projet", projetService.getProjet(id));
		return "detailprojet";
	}

	@PostMapping("/ajoutemploye")
	public String ajoutEmploye(@RequestParam("projetId") long id, @ModelAttribute Employe employe) {
		projetService.addEmploye(id, employe);
		return "redirect:/projets";
	}

	@PostMapping("/enleveremploye")
	public String enleverEmploye(@RequestParam("projetId") long id, @ModelAttribute Employe employe) {
		projetService.removeEmploye(id, employe);
		return "redirect:/projets";
	}

	@GetMapping("/ajouter")
	public String AjouterProjet(Model model) {
		Projet projet = new Projet();
		model.addAttribute(projet);
		return "ajoutprojet";
	}

	@PostMapping("/ajouter")
	public String postAjouterProjet(@ModelAttribute Projet projet) {
		System.out.println(projet);
		projetService.addProjet(projet);
		return "redirect:/projets";
	}

	@PostMapping("/supprimer/{id}")
	public String supprimerProjet(@PathVariable("id") Long id) {
		Projet projetAeffacer = projetService.getProjet(id);
		projetService.deleteProjet(projetAeffacer);
		return "redirect:/projets";
	}

	@GetMapping("modifier/{id}")
	public String modifierProjet(@PathVariable("id") Long id, Model model) {
		model.addAttribute("projet", projetService.getProjet(id));
		return "modifierprojet";
	}

	@PostMapping("modifier/{id}")
	public String postModifierProjet(@PathVariable("id") Long id, @ModelAttribute Projet projet) {
		projetService.modifyProjet(id, projet);
		return "redirect:/projets";
	}

}
