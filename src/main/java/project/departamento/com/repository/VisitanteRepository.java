package project.departamento.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Visitante;


public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

	
	/*buscar si existe el documento*/
	public Optional<Visitante> findByDocumento(String documento);
	
	public Optional<Visitante> findByTelefono(String telefono);
	
	public Optional<Visitante> findByCorreo(String correo);
	
	@Query("select v from Visitante v where v.documento = ?1")
	public List<Visitante> buscarDocumento(String documento);
		
	@Query("select v from Visitante v where v.documento =?1 and v.idVisitante <> ?2")
	public Optional<Visitante> buscarDocumentoactualizar(String documento, int codigo);
	
	@Query("select v from Visitante v where v.telefono =?1 and v.idVisitante <> ?2")
	public Optional<Visitante> buscarTelefonoactualizar(String telefono, int codigo);

	@Query("select v from Visitante v where v.correo =?1 and v.idVisitante <> ?2")
	public Optional<Visitante> buscarCorreoactualizar(String correo, int codigo);
	
	
	
	
}	
