package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Incidencias;
import project.departamento.com.entity.TipoIncidencias;
import project.departamento.com.repository.ClienteRepository;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.IncidenciasRepository;
import project.departamento.com.repository.TipoIncidenciasRepository;

@Service
public class IncidenciasServiceImpl implements IncidenciasService{
	
	@Autowired
	private IncidenciasRepository incidenciasRepository;
	
	@Autowired
	private TipoIncidenciasRepository tipoIncidenciasRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<TipoIncidencias> listarTipoIncidencias() {
		return tipoIncidenciasRepository.findAll();
	}

	@Override
	public Incidencias registrarIncidencias(Incidencias bean) {
		return incidenciasRepository.save(bean);
	}

	@Override
	public List<Incidencias> listarIncidencias() {
		return incidenciasRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamento() {
		return departamentoRepository.findAll();
	}

	@Override
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

}
