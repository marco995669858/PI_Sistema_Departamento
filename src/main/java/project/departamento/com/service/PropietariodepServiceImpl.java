package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Propietariodep;
import project.departamento.com.repository.PropietariodepRepository;

@Service
public class PropietariodepServiceImpl implements PropietariodepService{
	
	@Autowired
	private PropietariodepRepository repository;
	
	@Override
	public List<Propietariodep> listarPropietariosdep() {
		return repository.findAll();
	}

	@Override
	public List<Propietariodep> buscardni(String dni) {
		return repository.findByDni(dni);
	}

	@Override
	public List<Propietariodep> buscarcelular(String celular) {
		return repository.findByCelular(celular);
	}

	@Override
	public List<Propietariodep> buscarcorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	public void registra_actualiza_propietario(Propietariodep propietariodep) {
		repository.save(propietariodep);
	}

}
