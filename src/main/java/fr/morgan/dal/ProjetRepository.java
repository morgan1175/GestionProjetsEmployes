package fr.morgan.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.morgan.bo.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
