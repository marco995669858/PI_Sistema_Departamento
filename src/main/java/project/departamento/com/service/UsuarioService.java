package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Usuario;

public interface UsuarioService {
	/* listar todos los usuarios distintos del codigo 1000 */
	public abstract List<Usuario> listarUsuariosDistintodelAdministrador();

	/* listado de todos los usuarios */
	public abstract List<Usuario> listarUsuarios();

	/* para registrar un usuario */
	public abstract void registrarUsuario(Usuario bean);

	public abstract List<Usuario> obtieneAdministrador();
}
