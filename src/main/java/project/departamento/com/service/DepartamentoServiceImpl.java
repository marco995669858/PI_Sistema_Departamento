package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoRepository repository;
	
	@Override
	public void registraActualizaDepartamento(Departamento bean) {
		repository.save(bean);
	}

	@Override
	public List<Departamento> listarDepartamento() {
		return repository.findAll();
	}

	
	

}
