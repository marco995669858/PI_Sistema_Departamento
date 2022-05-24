package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoDocumento;
import project.departamento.com.entity.Visitante;
import project.departamento.com.repository.ClienteRepository;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.TipoDocumentoRepository;
import project.departamento.com.repository.VisitanteRepository;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteRepository repository;
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Visitante> listarTodoslosVisitantes() {
		return repository.findAll();
	}

	@Override
	public void eliminarVisitante(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public Visitante registraActualizaVisitante(Visitante bean) {
		return repository.save(bean);
	}

	@Override
	public List<TipoDocumento> listarTipoDocumento() {
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamento() {
		return departamentoRepository.findAll();
	}

	@Override
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Visitante> buscarDocumento(String documento) {
		return repository.findByDocumento(documento);
	}

	@Override
	public Optional<Visitante> buscarTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}

	@Override
	public Optional<Visitante> buscarCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

}
