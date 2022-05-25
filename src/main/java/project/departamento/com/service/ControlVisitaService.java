package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Visita;
import project.departamento.com.entity.Visitante;

public interface ControlVisitaService {
	
	/*crud*/
	public abstract Visita registraActualiza(Visita bean);
	
	public abstract List<Visitante> listarVisitanteCombo();
	
	public abstract Optional<Visitante> buscarVisitanteporDni(String documento);

}
