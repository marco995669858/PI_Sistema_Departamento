package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Incidente;

 
public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{

}
