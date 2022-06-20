package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.PagodeServicios;

public interface PagosServiciosService {
	
	public abstract List<Departamento> listarDepartamentos();
	
	public abstract List<PagodeServicios> listarPagodeServicios();
	
	public abstract DocumentoTributario buscarPorCodigo(int codigo);
	
	public abstract DocumentoTributario registrarDocumentoTributario(DocumentoTributario bean);
	
	public abstract List<DocumentoTributario> listarDocumentoTributario();
	
	public abstract DocumentoTributario actualizarDocumentoTributario(DocumentoTributario bean);
	
}
