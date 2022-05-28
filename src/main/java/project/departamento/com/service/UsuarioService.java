package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;

public interface UsuarioService {

	/* para buscar los usuarios que si existen */

	public abstract List<Usuario> listarTodosLosUsuarioActivos(int eliminado);

	public abstract Optional<Usuario> buscarCorreo(String correo);

	public abstract Optional<Usuario> buscarTelefono(String telefono);

	public abstract void eliminarUsuario(Integer codigo);

	public abstract Usuario registrarActualizaUsuario(Usuario bean);


	public abstract List<Rol> listarRoles();
}
