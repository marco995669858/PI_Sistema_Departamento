package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Cliente;

public interface ClienteService {

	public Optional<Cliente> buscarDocumento(String documento);

	public Optional<Cliente> buscarCorreo(String correo);

	public Optional<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento);

	public Optional<Cliente> buscarTelefono(String telefono);

	public abstract List<Cliente> listarTodoslosClientes();

	public abstract void eliminarCliente(Integer codigo);

	public abstract Cliente registrarActualizarCliente(Cliente bean);
}
