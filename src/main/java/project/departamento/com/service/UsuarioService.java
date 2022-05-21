package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> listarTodosLosUsuario();

	public Optional<Usuario> buscarCorreo(String correo);
	
	public Optional<Usuario> buscarTelefono(String telefono);
	
	public abstract void eliminarUsuario(Integer codigo);
	
	public abstract Usuario registrarActualizaUsuario(Usuario bean); 
}
