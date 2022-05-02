package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 
import project.departamento.com.entity.Usuario;

public interface LoginRepository  extends JpaRepository<Usuario, Integer> {
 
	@Query("select u from Usuario u where u.correo = ?1")
	public abstract Usuario BuscarUsuario(String correo);
	
	
	
	
}
