package project.departamento.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void registrarUsuario(Usuario bean) {
		repository.save(bean);
	}

}
