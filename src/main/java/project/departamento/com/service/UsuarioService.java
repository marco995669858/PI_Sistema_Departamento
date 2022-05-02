package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;

public interface UsuarioService {
	
	/*para listar a los usuarios*/
	public List<Usuario> listarUsuarios();
	
	/*para listar los roles*/
	public List<Rol> listarRoles();

	/*para buscar si existe el correo*/
	
	public List<Usuario> buscarUser(String user);
	
	//para registrar y actualizar el usuario
	public void registra_actualiza_usuario(Usuario usuario);
	
}
