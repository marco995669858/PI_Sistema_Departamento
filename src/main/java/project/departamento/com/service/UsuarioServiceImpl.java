package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.RolRepository;
import project.departamento.com.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RolRepository rolRepository;
	

	@Override
	public Optional<Usuario> buscarCorreo(String correo) {
		return repository.buscarCuentaUsuario(correo);
	}

	@Override
	public Optional<Usuario> buscarTelefono(String telefono) {
		return repository.buscarTelefono(telefono);
	}

	
	@Override
	public List<Usuario> listarTodosLosUsuarioActivos(int eliminado) {
		return repository.findByEliminado(eliminado);
	}

	@Override
	public void eliminarUsuario(Integer codigo) {
		repository.deleteById(codigo);
		
	}

	@Override
	public Usuario registrarActualizaUsuario(Usuario bean) {
		return repository.save(bean);
	}

	@Override
	public List<Rol> listarRoles() {
		return rolRepository.findAll();
	}



}
