package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Visita;

public interface ControlVisitaRepository extends JpaRepository<Visita, Integer>{
	

}
