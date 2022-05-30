package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.Visita;
import project.departamento.com.entity.Visitante;

public interface ConsultaVisitaService {
	
	public abstract Visita buscarporCodigo(int codigo);
	
	public abstract List<Visitante> listarVisitante();
	
	public abstract List<Cliente> listarCliente();
	
	public abstract List<Estado> listarEstado(int salio, int nosalio);
	
	public abstract List<Visita> consultaVisita(int visitante, int cliente, int estado);
	
	public abstract Visita actualizarVistaFecheSalida(Visita bean); 
}
