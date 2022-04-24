package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Usuario;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	
	
	@Query("select u.usuario, u.rol from UsuarioHasRol u where u.rol.idRol= 1000")
	public abstract List<Usuario> obtieneAdministrador();
  
	@Query("select u from Usuario u where u.idUsuario <> 1000")
	public abstract List<Usuario> listarUsuariosDistintosdelAdministrador();

}
