package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	/*para buscar si existe el numero de departamentos o el telefono*/
	public List<Departamento> findByNroDepartamentoOrTelefono(int nroDepartamento, String telefono);
}
