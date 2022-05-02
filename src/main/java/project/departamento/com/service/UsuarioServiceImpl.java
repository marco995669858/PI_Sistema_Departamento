package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.RolRepository;
import project.departamento.com.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public void registra_actualiza_usuario(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public List<Usuario> buscarUser(String user) {
		return repository.findByUser(user);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public List<Rol> listarRoles() {
		return rolRepository.findAll();
	}

 
}
