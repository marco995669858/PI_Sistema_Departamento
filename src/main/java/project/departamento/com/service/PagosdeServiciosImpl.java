package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.PagodeServicios;
import project.departamento.com.repository.ClienteRepository;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.DocumentoTributarioRepository;
import project.departamento.com.repository.PagosdeServiciosRepository;

@Service
public class PagosdeServiciosImpl implements PagosServiciosService{
	
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
	public List<PagodeServicios> listarPagodeServicios() {
		return pagosdeServiciosRepository.findAll();
	}

	@Override
	public DocumentoTributario registrarDocumentoTributario(DocumentoTributario bean) {
		return documentoTributarioRepository.save(bean);
	}

	@Override
	public List<DocumentoTributario> listarDocumentoTributario() {
		return documentoTributarioRepository.findAll();
	}
	
	
}
