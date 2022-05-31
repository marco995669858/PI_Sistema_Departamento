package project.departamento.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	@Query("select d from Departamento d where d.nroDepartamento = ?1")
	public Optional<Departamento> buscarNroDepartamento(String nroDepartamento);
	
	@Query("select d from Departamento d where d.nroDepartamento = ?1 and d.idDepartamento <> ?2")
	public Optional<Departamento> buscarDepartamentoExistente(String nroDepartamento, int idDepartamento);
	
	public List<Departamento> findByEliminado(int eliminado);
}
