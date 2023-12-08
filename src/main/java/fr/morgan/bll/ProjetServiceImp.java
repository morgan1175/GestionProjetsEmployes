package fr.morgan.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.morgan.bo.Employe;
import fr.morgan.bo.Projet;
import fr.morgan.dal.ProjetRepository;

@Service
public class ProjetServiceImp implements ProjetService {

	@Autowired
	ProjetRepository projetRepository;
	
	@Override
	public List<Projet> getProjets() {
		return projetRepository.findAll();
	}

	@Override
	public Projet getProjet(Long id) {
		return projetRepository.findById(id).get();
	}

		
	@Override
	public Projet addEmploye(Long ProjectId, Employe employe) {
		Projet projet = projetRepository.findById(ProjectId).get();
		projet.addEmploye(employe);
		projetRepository.save(projet);
		return projet;
	}
	
	

	@Override
	public Projet removeEmploye(Long ProjectId, Employe employe) {
		Projet projet = projetRepository.findById(ProjectId).get();
		projet.removeEmploye(employe);
		projetRepository.save(projet);
		return projet;
	}
	

	@Override
	public void addProjet(Projet projet) {
		projetRepository.save(projet);
		
	}

	@Override
	public void deleteProjet(Projet projet) {
		projetRepository.delete(projet);
		
	}

	@Override
	public Projet modifyProjet(Long id, Projet projet) {
		projetRepository.save(projet);
		return projet;
	}

	
}
