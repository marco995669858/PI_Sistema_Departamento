package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

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


	@Override
	public Optional<Departamento> buscarNroDepartamento(String nroDepartamento) {
		return repository.buscarNroDepartamento(nroDepartamento);
	}


	@Override
	public Departamento buscarDepartamentoporcodigo(Integer codigo) {
		return repository.findById(codigo).orElse(null);
	}


	@Override
	public List<Departamento> DepartamentosActivos(int eliminado) {
		return repository.findByEliminado(eliminado);
	}

}
