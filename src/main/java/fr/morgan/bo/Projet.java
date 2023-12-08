package fr.morgan.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Projet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Column(name = "date_debut")
	private LocalDate dateDebut;
	@Column(name = "date_fin")
	private LocalDate dateFin;

	@ManyToMany
	@JoinTable(name = "projet_equipe", joinColumns = @JoinColumn(name = "projet_id"), inverseJoinColumns = @JoinColumn(name = "employe_id"))
	private List<Employe> equipe = new ArrayList<Employe>();


	public Projet() {
		super();
	}

	public Projet(String nom, LocalDate dateDebut, LocalDate dateFin, List<Employe> equipe) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.equipe = equipe;
	}
	
	// Methodes pour gerer la relation de maniere bidirectionnelle
		public void addEmploye(Employe employe) {
			equipe.add(employe);
			employe.getProjets().add(this);
		}

		public void removeEmploye(Employe employe) {
			equipe.remove(employe);
			employe.getProjets().remove(this);
		}

		// Méthode pour supprimer les employés des projets sans supprimer les employes
		public void removeProjetsEmployes() {
			if (!equipe.isEmpty()) {
				for (Employe employe:equipe) {
					employe.getProjets().remove(this);
				}
				equipe.clear();
			}
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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public List<Employe> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Employe> equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin +  "]";
	}

}
