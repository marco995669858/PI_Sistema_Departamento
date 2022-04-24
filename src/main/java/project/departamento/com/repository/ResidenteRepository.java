package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Residente;

public interface ResidenteRepository extends JpaRepository<Residente, Integer>{
	
//	@Query("select d from Residente d.departamento.idDepartamento = ?1")
//	public abstract List<Residente> buscarDepartamento(int idDepartamento);
//	
//	@Query("select d from Residente d.usuario.idUsuario = ?1")
//	public abstract List<Residente> buscarUsuario(int idUsuario);
}
