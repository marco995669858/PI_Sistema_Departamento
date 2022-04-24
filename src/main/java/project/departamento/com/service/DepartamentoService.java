package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Departamento;

public interface DepartamentoService {
	
	/*para listar los departamentos*/
	public abstract List<Departamento> listarDepartamento();
	/*para guardar los departamentos*/
	public abstract void registraActualizaDepartamento(Departamento bean);
}
