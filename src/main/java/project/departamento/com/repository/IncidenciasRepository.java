package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Incidencias;

public interface IncidenciasRepository extends JpaRepository<Incidencias, Integer>{
	
	@Query("select i from Incidencias i where i.idincidente = ?1")
	public Incidencias buscarPorCodigo(int codigo);
}
