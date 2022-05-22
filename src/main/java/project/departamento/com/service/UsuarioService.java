package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;

public interface UsuarioService {

	/* para buscar los usuarios que si existen */
//	public abstract Optional<Usuario> buscarCuentaUsuario(String correo);
//
//	public abstract Optional<Usuario> buscarTelefonovacio(String telefono);

	public abstract Usuario buscarUsarioPorCodigo(Integer codigo);

	public abstract List<Usuario> listarTodosLosUsuarioActivos(int eliminado);

	public abstract Optional<Usuario> buscarCorreo(String correo);

	public abstract Optional<Usuario> buscarTelefono(String telefono);

	public abstract void eliminarUsuario(Integer codigo);

	public abstract Usuario registrarActualizaUsuario(Usuario bean);

	public abstract Usuario eliminarUsuario(Usuario bean);

	public abstract List<Rol> listarRoles();
}
