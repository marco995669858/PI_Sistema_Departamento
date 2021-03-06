package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.Incidencias;
import project.departamento.com.entity.TipoIncidencias;

public interface IncidenciasService {
	
	public abstract Incidencias buscarIncidencias(int codigo);
	
	public abstract List<Departamento> listarDepartamento();
	
	public abstract List<TipoIncidencias> listarTipoIncidencias();
	
	public abstract Incidencias registrarIncidencias(Incidencias bean);
	
	public abstract List<Incidencias> listarIncidencias();
	
	public abstract List<Cliente> listarClientes();
	
	public abstract List<Estado> listarEstadoIncidencias(int atendido, int noatendido, int pendiente);
	
	public abstract void eliminarIncidencia(int codigo);
}
