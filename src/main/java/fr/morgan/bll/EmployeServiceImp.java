package fr.morgan.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.morgan.bo.Employe;
import fr.morgan.bo.Projet;
import fr.morgan.dal.EmployeRepository;
import fr.morgan.dal.ProjetRepository;

@Service
public class EmployeServiceImp implements EmployeService {

	@Autowired
	public EmployeRepository employeRepository;

	@Autowired
	ProjetRepository projetRepository;

	@Override
	public List<Employe> getEmployes() {
		return employeRepository.findAll();

	}

	@Override
	public Employe addProject(Long employeId, Projet projet) {
		// recuperation de l'employe par son id
		Employe employe = employeRepository.findById(employeId).get();
		// on lui ajoute le projet par la methode dans Employe
		employe.addProjet(projet);
		// on persiste dans la base de donnees
		employeRepository.save(employe);
		return employe;
	}

	@Override
	public Employe getEmploye(Long id) {
		return employeRepository.findById(id).get();
	}

	@Override
	public void addEmploye(Employe employe) {
		employeRepository.save(employe);

	}

	@Override
	public void Delete(Employe employe) {
		employeRepository.delete(employe);

	}

	@Override
	public Employe modifyEmploye(Long id, Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Projet> getProjects() {
		return projetRepository.findAll();
	}

	
}
