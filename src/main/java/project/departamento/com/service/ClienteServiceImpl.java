package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Cliente;
import project.departamento.com.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Optional<Cliente> buscarDocumento(String documento) {
		return repository.findByDocumento(documento);
	}

	@Override
	public Optional<Cliente> buscarCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	public Optional<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento) {
		return repository.buscarClienteDepartamentoquenoExistan(departamento);
	}

	@Override
	public Optional<Cliente> buscarTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}
	
	@Override
	public List<Cliente> listarTodoslosClientes() {
		return repository.findAll();
	}

	@Override
	public void eliminarCliente(Integer codigo) {
		repository.deleteById(codigo);
		
	}

	@Override
	public Cliente registrarActualizarCliente(Cliente bean) {
		return repository.save(bean);
	}

	

}
