package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.servicios;

public interface GenerarboletaService {
	
	public abstract List<Departamento> listarDepartamentos();
	
	public abstract List<servicios> listarPagodeServicios();
	
	public abstract Optional<DocumentoTributario> buscarFechaPagoPresente(String fechaPago, int servicios);
	
	public abstract DocumentoTributario registrarDocumentoTributario(DocumentoTributario bean);
	
	
	
}
