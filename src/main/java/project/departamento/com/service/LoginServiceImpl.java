package project.departamento.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Usuario buscarUsuario(String gmail) {
		// TODO Auto-generated method stub
		return loginRepository.BuscarUsuario(gmail);
	}

 
}
