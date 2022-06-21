package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.BoletaPago;
import project.departamento.com.entity.DocumentoTributario;

public interface PagoBoletaService {
	public abstract DocumentoTributario buscarPorCodigo(int codigo);
	
	public abstract DocumentoTributario pagarDocumentoTributario(DocumentoTributario bean);

	public abstract List<DocumentoTributario> listarDocumentoTributario();

	public abstract BoletaPago registrarBoletapago(BoletaPago bean);
}
