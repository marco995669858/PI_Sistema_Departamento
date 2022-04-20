package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Usuario;

public interface UsuarioService {
	
	/*listado de todos los usuarios*/
	public abstract List<Usuario> listarUsuarios();
	
	/*para registrar un usuario*/
	public abstract void registrarUsuario(Usuario bean);
}
