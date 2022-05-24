package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoDepartamento;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.TipoDepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoRepository repository;
	
	@Autowired
	private TipoDepartamentoRepository tipoDepartamentoRepository;
	
	
	@Override
	public List<TipoDepartamento> listarTipoDepartamento() {
		return tipoDepartamentoRepository.findAll();
	}


	@Override
	public Departamento registraActualizaDepartamento(Departamento bean) {
		return repository.save(bean);
	}


	@Override
	public Departamento eliminarDepartamento(Departamento bean) {
		return repository.save(bean);
	}


	@Override
	public List<Departamento> listarDepartamentos() {
		return repository.findAll();
	}

}
