package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoCliente;
import project.departamento.com.entity.TipoDocumento;
import project.departamento.com.repository.ClienteRepository;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.TipoClienteRepository;
import project.departamento.com.repository.TipoDocumentoRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private TipoDocumentoRepository documentoRepository;
	
	@Autowired
	private TipoClienteRepository clienteRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public Optional<Cliente> buscarDocumento(String documento, Integer IdCliente) {
		return repository.buscarDocumento(documento,IdCliente);
	}

	@Override
	public Optional<Cliente> buscarCorreo(String correo, Integer IdCliente) {
		return repository.buscarCorreo(correo,IdCliente);
	}

	@Override
	public Optional<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento, Integer idUsuario) {
		return repository.buscarClienteDepartamentoquenoExistan(departamento, idUsuario);
	}

	@Override
	public Optional<Cliente> buscarTelefono(String telefono, Integer IdCliente) {
		return repository.busacarTelefono(telefono,IdCliente);
	}
	
	@Override
	public List<Cliente> listarTodoslosClientes() {
		return repository.findAll();
	}


	@Override
	public Cliente registrarActualizarCliente(Cliente bean) {
		return repository.save(bean);
	}


	@Override
	public List<Cliente> buscarClienteporid(Integer idCliente) {
		return repository.findByIdCliente(idCliente);
	}

	@Override
	public void eliminarCliente(int codigo) {
		 repository.deleteById(codigo);
		
	}

	@Override
	public List<TipoDocumento> listarTipoDocumento() {
		return documentoRepository.findAll();
	}

	@Override
	public List<TipoCliente> listarTipoClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamento() {
		return departamentoRepository.findAll();
	}

	@Override
	public List<Cliente> listarEliminadoactivo(int eliminado) {
		return repository.findByEliminado(eliminado);
	}

	@Override
	public Cliente buscarClienteparaactualizar(int codigo) {
		return repository.findById(codigo).orElse(null);
	}

	
	

}
