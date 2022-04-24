package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	
}
