package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.servicios;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.DocumentoTributarioRepository;
import project.departamento.com.repository.PagosdeServiciosRepository;

@Service
public class GenerarBoletaServiceImpl implements GenerarboletaService{
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private PagosdeServiciosRepository pagosdeServiciosRepository;
	
	@Autowired
	private DocumentoTributarioRepository documentoTributarioRepository;
	
	@Override
	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}

	@Override
	public List<servicios> listarPagodeServicios() {
		return pagosdeServiciosRepository.findAll();
	}

	@Override
	public DocumentoTributario registrarDocumentoTributario(DocumentoTributario bean) {
		return documentoTributarioRepository.save(bean);
	}

	@Override
	public Optional<DocumentoTributario> buscarFechaPagoPresente(String fechaPago, int servicios) {
		return documentoTributarioRepository.buscarFechaPagoPresente(fechaPago, servicios);
	}


	
	
}
