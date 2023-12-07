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
	public void addProjet(Projet projet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProjet(Projet projet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Projet modifyProjet(Long id, Projet projet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> getEquipe() {
		// TODO Auto-generated method stub
		return null;
	}

}
