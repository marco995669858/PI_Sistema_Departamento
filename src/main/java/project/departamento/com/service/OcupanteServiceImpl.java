package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Ocupantes;
import project.departamento.com.entity.RelacionconPropietario;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.OcupanteRepository;
import project.departamento.com.repository.RelacionconPropietarioRepository;

@Service
public class OcupanteServiceImpl implements OcupanteService {

	
	
	@Autowired
	private OcupanteRepository repository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private RelacionconPropietarioRepository relacionRepository;
					
	@Override
	public List<Ocupantes> listarOcupantes() {
		return repository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}

	@Override
	public void registra_actualiza_ocupante(Ocupantes ocupante) {
		repository.save(ocupante);
		
	}

	@Override
	public List<RelacionconPropietario> listarRelacionconPropietario() {
			return relacionRepository.findAll();
	}

}
