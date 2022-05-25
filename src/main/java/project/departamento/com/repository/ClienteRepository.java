package project.departamento.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("select d from Cliente d where d.documento=?1 and d.idCliente <> ?2")
	public Optional<Cliente> buscarDocumento(String documento, Integer IdCliente);
	
	@Query("select d from Cliente d where d.correo=?1 and d.idCliente <> ?2")
	public Optional<Cliente> buscarCorreo(String correo, Integer IdCliente);
	
	@Query("select d from Cliente d where d.departamento.idDepartamento=?1 and d.idCliente <> ?2")
	public Optional<Cliente> buscarClienteDepartamentoquenoExistan(Integer departamento, Integer idUsuario);
	
	@Query("select d from Cliente d where d.telefono=?1 and d.idCliente <> ?2")
	public Optional<Cliente> busacarTelefono(String telefono, Integer IdCliente);
	
//	@Query("update Cliente c set eliminado = ?1 where idCliente=?2")
//	public String eliminarCliente(int eliminado, Integer idCliente);
	
	public List<Cliente> findByIdCliente(Integer idCliente);
	
	public List<Cliente> findByEliminado(int eliminado);
}
