package project.departamento.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.DocumentoTributario;

public interface DocumentoTributarioRepository extends JpaRepository<DocumentoTributario, Integer>{
	
	@Query("select d from DocumentoTributario d where d.fechaPago = ?1 and d.servicios.idServicios = ?2")
	public Optional<DocumentoTributario>  buscarFechaPagoPresente(String fechaPago, int servicios);

}
