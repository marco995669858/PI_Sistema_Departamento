package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	
	
 
	/*para buscar si el correo existe*/
	public List<Usuario> findByUser(String user);
	
}
