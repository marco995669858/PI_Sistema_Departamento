package project.departamento.com.service;

import java.util.List;

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
	public List<Visitante> buscarDocumento(String documento) {
		return repository.findByDocumento(documento);
	}

	@Override
	public List<Visitante> buscarTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}

	@Override
	public List<Visitante> buscarCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	public Visitante buscarVisitantepordni(String dni) {
		return repository.buscarDocumento(dni);
	}

	@Override
	public Visitante buscarVisitantePorCodigo(Integer codigo) {
		return repository.buscarPorcodigo(codigo);
	}

	@Override
	public List<Visitante> buscarDocumentoactualizar(String documento, int codigo) {
		return repository.buscarDocumentoactualizar(documento, codigo);
	}

	@Override
	public List<Visitante> buscarTelefonoactualizar(String telefono, int codigo) {
		return repository.buscarTelefonoactualizar(telefono, codigo);
	}

	@Override
	public List<Visitante> buscarCorreoactualizar(String correo, int codigo) {
		return repository.buscarCorreoactualizar(correo, codigo);
	}

}
