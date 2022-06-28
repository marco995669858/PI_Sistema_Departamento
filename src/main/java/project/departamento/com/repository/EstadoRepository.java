package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	@Query("select e from Estado e where e.idEstado=?1 or e.idEstado=?2")
	public List<Estado> listarEstados(int ocupado, int desocupado);
	
	@Query("select e from Estado e where e.idEstado=?1 or e.idEstado=?2")
	public List<Estado> listarEstadosVisita(int salio, int nosalio);
	
	@Query("select e from Estado e where e.idEstado=?1 or e.idEstado=?2 or e.idEstado=?3")
	public List<Estado> listarEstadosIncidentes(int atendido, int noatendido , int pendiente );
}
