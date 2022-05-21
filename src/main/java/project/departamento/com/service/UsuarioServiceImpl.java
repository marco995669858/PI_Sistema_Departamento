package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	

	@Override
	public Optional<Usuario> buscarCorreo(String correo) {
		return repository.findByCuentaUsuario(correo);
	}

	@Override
	public Optional<Usuario> buscarTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}

	
	@Override
	public List<Usuario> listarTodosLosUsuario() {
		return repository.findAll();
	}

	@Override
	public void eliminarUsuario(Integer codigo) {
		repository.deleteById(codigo);
		
	}

	@Override
	public Usuario registrarActualizaUsuario(Usuario bean) {
		return repository.save(bean);
	}

}
