package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Edificio;
import project.departamento.com.repository.EdificioRepository;

@Service
public class EdificioServiceImpl implements EdificioService{
	
	@Autowired
	private EdificioRepository repository;
	
	@Override
	public List<Edificio> listarEdificio() {
		return repository.findAll();
	}

}
