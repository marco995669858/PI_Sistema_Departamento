package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Enlace;
import project.departamento.com.entity.Usuario;

public interface LoginService {

	public abstract Usuario buscarUsuario(String cuentaUsuario);
	public abstract List<Enlace> traenEnlaces(int idRol);
}
