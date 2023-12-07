package fr.morgan.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.morgan.bo.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
