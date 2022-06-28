package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Visitante;


public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

	
	/*buscar si existe el documento*/
	public List<Visitante> findByDocumento(String documento);
	
	public List<Visitante> findByTelefono(String telefono);
	
	public List<Visitante> findByCorreo(String correo);
	
	@Query("select v from Visitante v where v.documento = ?1")
	public Visitante buscarDocumento(String documento);
		
	@Query("select v from Visitante v where v.documento =?1 and v.idVisitante <> ?2")
	public List<Visitante> buscarDocumentoactualizar(String documento, int codigo);
	
	@Query("select v from Visitante v where v.telefono =?1 and v.idVisitante <> ?2")
	public List<Visitante> buscarTelefonoactualizar(String telefono, int codigo);

	@Query("select v from Visitante v where v.correo =?1 and v.idVisitante <> ?2")
	public List<Visitante> buscarCorreoactualizar(String correo, int codigo);
	
	@Query("select v from Visitante v where v.idVisitante =?1")
	public Visitante buscarPorcodigo(int codigo);
	
	
	
	
}	
