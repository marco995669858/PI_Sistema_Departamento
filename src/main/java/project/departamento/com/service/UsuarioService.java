package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;

public interface UsuarioService {

	public abstract Usuario buscarUsarioPorCodigo(Integer codigo);
	
	public abstract List<Usuario> listarTodosLosUsuario();

	public abstract Optional<Usuario> buscarCorreo(String correo);
	
	public abstract Optional<Usuario> buscarTelefono(String telefono);
	
	public abstract void eliminarUsuario(Integer codigo);
	
	public abstract Usuario registrarActualizaUsuario(Usuario bean); 
	
	public abstract Usuario eliminarUsuario(Usuario bean);
	
	public abstract List<Rol> listarRoles();
}
