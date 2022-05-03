package project.departamento.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	/*para buscar si existe el numero de departamentos o el telefono*/
	public Optional<Departamento> findByNroDepartamento(int nroDepartamento);
	public Optional<Departamento> findByTelefono(String telefono);
}
