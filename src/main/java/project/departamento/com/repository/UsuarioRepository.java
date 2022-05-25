package project.departamento.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Enlace;
import project.departamento.com.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select c from Usuario c where c.cuentaUsuario = ?1 and c.eliminado <> 1")
	public Optional<Usuario> buscarCuentaUsuario(String correo);
	
	@Query("select t from Usuario t where t.telefono = ?1 and t.eliminado <> 1")
	public Optional<Usuario> buscarTelefono(String telefono);
	
	public List<Usuario> findByEliminado(int eliminado);
	
	/*login*/
	
	@Query("select u from Usuario u where u.cuentaUsuario=?1")
	public Usuario iniciarSession(String login);
	
	@Query("select e from RolasEnlace re join re.enlace e where re.rol.idRol=?1")
	public List<Enlace> traearEnlaces(int idRol);
}
