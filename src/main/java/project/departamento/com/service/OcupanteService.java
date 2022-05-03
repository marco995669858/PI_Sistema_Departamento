package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Ocupantes;
import project.departamento.com.entity.RelacionconPropietario;

public interface OcupanteService {
/*para listar los ocupantes*/
	public List<Ocupantes> listarOcupantes();
	
	/*para listar los departamentos*/
	public List<Departamento> listarDepartamentos();
	
	
	/*para listar la relacion*/
	public List<RelacionconPropietario> listarRelacionconPropietario();
	
	
	/*para registrar llos departamentos*/
	public void registra_actualiza_ocupante(Ocupantes ocupante);
	
	/* para buscar si existe el dni, celular y el correo */
	public Optional<Ocupantes> buscardni(String dni);

	public Optional<Ocupantes> buscarcelular(String celular);

	public Optional<Ocupantes> buscarsexo(String sexo);
	
}
