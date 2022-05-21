package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Cliente;

public interface ClienteService {

	public abstract Optional<Cliente> buscarDocumento(String documento, Integer IdCliente);

	public abstract Optional<Cliente> buscarCorreo(String correo, Integer IdCliente);

	public abstract Optional<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento, Integer idUsuario);

	public abstract Optional<Cliente> buscarTelefono(String telefono, Integer IdCliente);

	public abstract List<Cliente> listarTodoslosClientes();

	public abstract List<Cliente> buscarClienteporid(Integer idCliente);
	
	public abstract void eliminarCliente(Integer codigo);

	public abstract Cliente registrarActualizarCliente(Cliente bean);
	
}
