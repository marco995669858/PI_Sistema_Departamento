package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Propietariodep;

public interface PropietariodepService {

	/* para listar los propietarios */
	public List<Propietariodep> listarPropietariosdep();

	/* para buscar si existe el dni, celular y el correo */
	public List<Propietariodep> buscardni(String dni);

	public List<Propietariodep> buscarcelular(String celular);

	public List<Propietariodep> buscarcorreo(String correo);

	/*para registrar el propietario*/
	public void registra_actualiza_propietario(Propietariodep propietariodep);
}
