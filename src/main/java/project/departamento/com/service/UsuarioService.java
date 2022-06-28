package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;

public interface UsuarioService {

	/* para buscar los usuarios que si existen */

	public abstract List<Usuario> listarTodosLosUsuarioActivos(int eliminado);

	public abstract List<Usuario> buscarCorreo(String correo);

	public abstract List<Usuario> buscarTelefono(String telefono);

	public abstract void eliminarUsuario(Integer codigo);

	public abstract Usuario registrarActualizaUsuario(Usuario bean);


	public abstract List<Rol> listarRoles();
}
