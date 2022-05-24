package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Enlace;
import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository rep;
	
	@Override
	public Usuario buscarUsuario(String cuentaUsuario) {
		// TODO Auto-generated method stub
		return rep.findByCuentaUsuario(cuentaUsuario);
	}

	@Override
	public List<Enlace> traenEnlaces(int idRol) {
		// TODO Auto-generated method stub
		return rep.obtEnlace(idRol);
	}

}
