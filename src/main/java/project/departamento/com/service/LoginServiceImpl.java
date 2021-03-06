package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Enlace;
import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.UsuarioRepository;

@Service
public class LoginServiceImpl implements LoginService{
	

	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario buscarUsuario(String cuentaUsuario) {
		return repository.iniciarSession(cuentaUsuario);
	}

	@Override
	public List<Enlace> traenEnlaces(int idRol) {
		return repository.traearEnlaces(idRol);
	}
	


}
