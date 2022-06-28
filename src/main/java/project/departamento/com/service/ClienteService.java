package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoCliente;
import project.departamento.com.entity.TipoDocumento;

public interface ClienteService {
	
	public abstract List<TipoDocumento> listarTipoDocumento();
	
	public abstract List<TipoCliente> listarTipoClientes();

	public abstract List<Departamento> listarDepartamento();
	
	public abstract List<Cliente> buscarDocumento(String documento, Integer IdCliente);

	public abstract List<Cliente> buscarCorreo(String correo, Integer IdCliente);

	public abstract List<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento, Integer idUsuario);

	public abstract List<Cliente> buscarTelefono(String telefono, Integer IdCliente);

	public abstract List<Cliente> listarTodoslosClientes();

	public abstract List<Cliente>  buscarClienteporid(Integer idCliente);
	
	public abstract void eliminarCliente(int codigo);

	public abstract Cliente registrarActualizarCliente(Cliente bean);
	
	public List<Cliente> listarEliminadoactivo(int eliminado);
	
	public abstract Cliente buscarClienteparaactualizar(int codigo);
	
}
