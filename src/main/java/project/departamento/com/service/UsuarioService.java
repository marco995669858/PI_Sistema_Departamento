package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> listarTodosLosUsuario();
	
	public abstract void eliminarUsuario(Integer codigo);
	
	public abstract Usuario registrarActualizaUsuario(Usuario bean); 
}
