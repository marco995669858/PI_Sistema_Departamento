package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoDepartamento;

public interface DepartamentoService {
	
	public abstract List<TipoDepartamento> listarTipoDepartamento();
	
	/*crud de departamento*/
	public abstract Departamento registraActualizaDepartamento(Departamento bean);
	
	public abstract Departamento eliminarDepartamento(Departamento bean);
	
	public abstract List<Departamento> listarDepartamentos();

}
