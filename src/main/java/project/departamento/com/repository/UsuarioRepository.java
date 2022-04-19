package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value = "{select concat(u.nombreCompleto, ' ', u.apellidoCompleto ) from Usuario u inner join UsuarioHasRolPK ur on u.idUsuario = ur.idUsuario where u.idUsuario = 1000}", nativeQuery = true)
	public abstract List<Usuario> listaAdministradorNombre();
}
