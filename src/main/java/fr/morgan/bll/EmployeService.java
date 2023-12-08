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
	void delete(Employe employe);
	Employe modifyEmploye(Long id, Employe employe);
	Employe addProject(Long employeId,Projet projet);
	Employe removeProject(Long employeId, Projet projet);
	Employe removeAllProjects(Long employeId);
	List<Projet> getAllProjects();
	List<Projet> getEmployeProjects(Employe employe);
}
