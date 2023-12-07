package fr.morgan.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.morgan.bo.Employe;
import fr.morgan.bo.Projet;

@Service
public interface EmployeService {

	List<Employe> getEmployes();
	Employe getEmploye(Long id);
	void addEmploye(Employe employe);
	void Delete(Employe employe);
	Employe modifyEmploye(Long id, Employe employe);
	Employe addProject(Long employeId,Projet projet);
	List<Projet> getProjects();
}
