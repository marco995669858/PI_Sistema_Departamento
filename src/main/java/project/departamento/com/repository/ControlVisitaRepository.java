package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Visita;

public interface ControlVisitaRepository extends JpaRepository<Visita, Integer> {

	@Query("select c from Visita c where (?1 is -1 or c.visitante.idVisitante=?1) and(?2 is -1 or c.cliente.idCliente=?2) and (?3 is -1 or c.estado.idEstado=?3) ")
	public List<Visita> listarConsultaVisitaporVisitanteClienteyEstado(int visita, int cliente, int estado);

}
