package fr.morgan.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.morgan.bo.Employe;
import fr.morgan.bo.Projet;

@Service
public interface ProjetService {

	List<Projet> getProjets();
	Projet getProjet(Long id);
	void addProjet(Projet projet);
	void deleteProjet(Projet projet);
	Projet modifyProjet(Long id, Projet projet);
	List<Employe> getEquipe();
	
}
