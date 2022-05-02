package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Edificio;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.EdificioRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoRepository repository;
	
	@Autowired
	private EdificioRepository edificioRepository;
	
	@Override
	public List<Edificio> listarEdificio() {
		return edificioRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamentos() {
		return repository.findAll();
	}

	@Override
	public List<Departamento> buscarDepartamento(int nroDepartamento, String telefono) {
		return repository.findByNroDepartamentoOrTelefono(nroDepartamento, telefono);
	}

	@Override
	public void registra_actualiza_departamento(Departamento departamento) {
		repository.save(departamento);
	}

 

	
	

}
