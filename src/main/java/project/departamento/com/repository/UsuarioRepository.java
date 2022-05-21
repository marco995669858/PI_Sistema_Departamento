package project.departamento.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Optional<Usuario> findByCuentaUsuario(String correo);
	
	public Optional<Usuario> findByTelefono(String telefono);
}
