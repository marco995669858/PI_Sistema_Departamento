package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Visitante;
import java.util.Optional;


public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

	
	/*buscar si existe el documento*/
	public Optional<Visitante> findByDocumento(String documento);
	
	public Optional<Visitante> findByTelefono(String telefono);
	
	public Optional<Visitante> findByCorreo(String correo);
	
	
	
}	
