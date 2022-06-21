package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.BoletaPago;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.repository.BoletaPagoRepository;
import project.departamento.com.repository.DocumentoTributarioRepository;

@Service
public class PagoBoletaServiceImpl implements PagoBoletaService{
	
	@Autowired
	private DocumentoTributarioRepository documentoTributarioRepository;
	
	@Autowired
	private BoletaPagoRepository boletaPagoRepository;
	
	@Override
	public List<DocumentoTributario> listarDocumentoTributario() {
		return documentoTributarioRepository.findAll();
	}

	@Override
	public BoletaPago registrarBoletapago(BoletaPago bean) {
		return boletaPagoRepository.save(bean);
	}

	@Override
	public DocumentoTributario buscarPorCodigo(int codigo) {
		return documentoTributarioRepository.findById(codigo).orElse(null);
	}

	@Override
	public DocumentoTributario pagarDocumentoTributario(DocumentoTributario bean) {
		return documentoTributarioRepository.save(bean);
	}

}
