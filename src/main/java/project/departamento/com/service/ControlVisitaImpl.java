package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Visita;
import project.departamento.com.entity.Visitante;
import project.departamento.com.repository.ControlVisitaRepository;
import project.departamento.com.repository.VisitanteRepository;

@Service
public class ControlVisitaImpl implements ControlVisitaService{

	@Autowired
	private ControlVisitaRepository controlVisitaRepository;
	
	@Autowired 
	private VisitanteRepository visitanteRepository;
	
	@Override
	public Visita registraActualiza(Visita bean) {
		return controlVisitaRepository.save(bean);
	}

	@Override
	public Optional<Visitante> buscarVisitanteporDni(String documento) {
		return visitanteRepository.findByDocumento(documento);
	}

	@Override
	public List<Visitante> listarVisitanteCombo() {
		return visitanteRepository.findAll();
	}

}
