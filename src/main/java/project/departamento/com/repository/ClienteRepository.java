package project.departamento.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public Optional<Cliente> findByDocumento(String documento);
	
	public Optional<Cliente> findByCorreo(String correo);
	
	@Query("select d from Cliente d where d.departamento.idDepartamento=?1")
	public Optional<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento);
	
	public Optional<Cliente> findByTelefono(String telefono);
}
