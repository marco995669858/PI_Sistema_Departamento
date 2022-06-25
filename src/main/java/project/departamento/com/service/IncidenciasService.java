package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Incidencias;
import project.departamento.com.entity.TipoIncidencias;

public interface IncidenciasService {
	
	public abstract List<TipoIncidencias> listarTipoIncidencias();
	
	public abstract Incidencias registrarIncidencias(Incidencias bean);
	
	public abstract List<Incidencias> listarIncidencias();
}
