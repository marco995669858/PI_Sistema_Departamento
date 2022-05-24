package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoDepartamento;

public interface DepartamentoService {
	
	public abstract List<TipoDepartamento> listarTipoDepartamento();
	
	/*crud de departamento*/
	public abstract Departamento registraActualizaDepartamento(Departamento bean);
	
	public abstract Departamento eliminarDepartamento(Departamento bean);
	
	public abstract List<Departamento> listarDepartamentos();
	
	public Optional<Departamento> buscarNroDepartamento(String nroDepartamento);
	 
	public abstract Departamento buscarDepartamentoporcodigo(Integer codigo); 
	
	public abstract List<Departamento> DepartamentosActivos(int eliminado);

}
