package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoDocumento;
import project.departamento.com.entity.Visitante;

public interface VisitanteService {
	
	public abstract List<TipoDocumento> listarTipoDocumento();
	
	public abstract List<Departamento> listarDepartamento();
	
	public abstract List<Cliente> listarCliente();
	
	/*para buscar si existe el documento, telefono y correo*/
	public abstract Optional<Visitante> buscarDocumento(String documento);
	
	public abstract Optional<Visitante> buscarTelefono(String telefono);
	
	public abstract Optional<Visitante> buscarCorreo(String correo);
	
	public abstract List<Visitante> listarTodoslosVisitantes();
	
	public abstract void eliminarVisitante(Integer codigo);
	
	public abstract Visitante registraActualizaVisitante(Visitante bean);
	
	public abstract List<Visitante> buscarVisitantepordni(String dni);
}
