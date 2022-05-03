package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Edificio;
import project.departamento.com.entity.TipoDepartamento;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.EdificioRepository;
import project.departamento.com.repository.TipoDepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoRepository repository;
	
	@Autowired
	private EdificioRepository edificioRepository;
	
	@Autowired
	private TipoDepartamentoRepository tipoDepartamentoRepository;
	
	@Override
	public List<Edificio> listarEdificio() {
		return edificioRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamentos() {
		return repository.findAll();
	}

	@Override
	public Optional<Departamento> buscarnroDepartamento(int nroDepartamento) {
		return repository.findByNroDepartamento(nroDepartamento);
	}

	@Override
	public void registra_actualiza_departamento(Departamento departamento) {
		repository.save(departamento);
	}

	@Override
	public List<TipoDepartamento> listarTipoDepartamento() {
		return tipoDepartamentoRepository.findAll();
	}

	@Override
	public Optional<Departamento> buscarTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}

 

	
	

}
