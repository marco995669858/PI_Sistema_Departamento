package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Edificio;
import project.departamento.com.entity.TipoDepartamento;

public interface DepartamentoService {
	
	/*para listar el edificio*/
	public List<Edificio> listarEdificio();
	
	/*para listar los tipos de departamentos*/
	public List<TipoDepartamento> listarTipoDepartamento();
	
	/*para listar los departamentos*/
	public List<Departamento> listarDepartamentos();
	
	/*para buscar si existe el numero del departamento*/
	
	public Optional<Departamento> buscarnroDepartamento(int nroDepartamento);
	
	public Optional<Departamento> buscarTelefono(String telefono);
	
	/*para registrar el departamento o actualizarlo*/
	public void registra_actualiza_departamento(Departamento departamento);
}
