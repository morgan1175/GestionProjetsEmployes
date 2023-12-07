package fr.morgan.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String poste;
	@Column(name = "date_embauche")
	private LocalDate dateEmbauche;
	@ManyToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private List<Projet> projets = new ArrayList<Projet>();

	public Employe() {
		super();
	}
	

	public Employe(String nom, String prenom, String poste, LocalDate dateEmbauche, List<Projet> projets) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.dateEmbauche = dateEmbauche;
		this.projets = projets;
	}


	// Methodes pour gerer la relation de maniere bidirectionnelle
	public void addProjet(Projet projet) {
		projets.add(projet);
		projet.getEquipe().add(this);
	}

	public void removeProjet(Projet projet) {
		projets.remove(projet);
		projet.getEquipe().remove(this);
	}

	//////////////////////////////////////////////////////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public List<Projet> getListeProjet() {
		return projets;
	}

	public void setListeProjet(List<Projet> listeProjet) {
		this.projets = listeProjet;
	}


	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste + ", dateEmbauche="
				+ dateEmbauche + ", projets=" + projets + "]";
	}

	

	
	
	

}
