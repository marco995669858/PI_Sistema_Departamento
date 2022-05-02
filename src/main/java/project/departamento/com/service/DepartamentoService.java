package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Edificio;

public interface DepartamentoService {
	
	/*para listar el edificio*/
	public List<Edificio> listarEdificio();
	
	/*para listar los departamentos*/
	public List<Departamento> listarDepartamentos();
	
	/*para buscar si existe el numero del departamento*/
	
	public List<Departamento> buscarDepartamento(int nroDepartamento);
	
	/*para registrar el departamento o actualizarlo*/
	public void registra_actualiza_departamento(Departamento departamento);
}
