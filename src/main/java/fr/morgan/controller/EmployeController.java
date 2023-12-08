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
@RequestMapping("employes")
public class EmployeController {

	@Autowired
	public EmployeService employeService;
	@Autowired
	public ProjetService projetService;

	@GetMapping
	private String listeEmployes(Model model) {
		model.addAttribute("employes", employeService.getEmployes());
		model.addAttribute("projets", employeService.getAllProjects());
		return "employes";
	}

	@GetMapping("/detail/{id}")
	public String detailEmploye(@PathVariable("id") Long id, Model model) {
		model.addAttribute("employe", employeService.getEmploye(id));
		return "detailemploye";
	}

	@PostMapping("/ajoutprojet")
	public String ajouterProjet(@RequestParam ("employeId") Long id, @ModelAttribute Projet projet) {
		employeService.addProject(id,projet);
		return "redirect:/employes";
	}
	
	@PostMapping("/enleverprojet")
	public String enleverProjet(@RequestParam ("employeId") Long id,@ModelAttribute Projet projet) {
		employeService.removeProject(id, projet);
		return "redirect:/employes";
	}
	
	@GetMapping("/modifier/{id}")
	public String modifierEmploye(@PathVariable("id") Long id,Model model) {
		model.addAttribute("employe",employeService.getEmploye(id));
		return "modifemploye";
	}
	
	@PostMapping("/modifier/{id}")
	public String postModifierEmploye(@PathVariable("id") Long id, @ModelAttribute Employe employe) {
		employeService.modifyEmploye(id, employe);
		return "redirect:/employes";
	}
	
	@PostMapping("supprimer/{id}")
	public String supprimerEmploye(@PathVariable("id") Long id) {
		Employe employeAeffacer = employeService.getEmploye(id);
		employeService.removeAllProjects(id);
		employeService.delete(employeAeffacer);
		return "redirect:/employes";
	}
	
	@GetMapping("/ajouter")
	public String ajouterEmploye(Model model) {
		Employe employe = new Employe();
		model.addAttribute("employe", employe);
		return "ajoutemploye";
	}
	
	@PostMapping("/ajouter")
	public String postAjouterEmploye(@ModelAttribute Employe employe) {
		employeService.addEmploye(employe);
		return "redirect:/employes";
	}
	

}
