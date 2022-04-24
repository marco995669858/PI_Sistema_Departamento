package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void registrarUsuario(Usuario bean) {
		repository.save(bean);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public List<Usuario> obtieneAdministrador() {
		return repository.obtieneAdministrador();
	}

	@Override
	public List<Usuario> listarUsuariosDistintodelAdministrador() {
		return repository.listarUsuariosDistintosdelAdministrador();
	}
}
