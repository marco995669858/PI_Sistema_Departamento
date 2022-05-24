package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.departamento.com.entity.Enlace;
import project.departamento.com.entity.Usuario;


public interface LoginRepository extends JpaRepository<Usuario, Integer> {
	
 
	public abstract Usuario findByCuentaUsuario(String user);
	
	@Query("select e from RolasEnlace re join re.enlace e where re.rol.idRol=?1")
	public List<Enlace> obtEnlace(int idRol);
}
