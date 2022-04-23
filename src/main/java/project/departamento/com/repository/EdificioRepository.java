package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
	
}
