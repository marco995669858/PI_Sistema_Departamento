package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.Visita;
import project.departamento.com.entity.Visitante;
import project.departamento.com.repository.ClienteRepository;
import project.departamento.com.repository.ControlVisitaRepository;
import project.departamento.com.repository.EstadoRepository;
import project.departamento.com.repository.VisitanteRepository;

@Service
public class ConsultaVisitaServiceImpl implements ConsultaVisitaService{
	
	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ControlVisitaRepository controlVisitaRepository;
	
	@Override
	public List<Visitante> listarVisitante() {
		return visitanteRepository.findAll();
	}

	@Override
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public List<Estado> listarEstado(int salio, int nosalio) {
		return estadoRepository.listarEstadosVisita(salio, nosalio);
	}
	
	@Override
	public List<Visita> consultaVisita(int visitante, int cliente, int estado) {
		return controlVisitaRepository.listarConsultaVisitaporVisitanteClienteyEstado(visitante, cliente, estado);
	}

	@Override
	public Visita actualizarVistaFecheSalida(Visita bean) {
		return controlVisitaRepository.save(bean);
	}

	@Override
	public Visita buscarporCodigo(int codigo) {
		return controlVisitaRepository.findById(codigo).orElse(null);
	}

}
