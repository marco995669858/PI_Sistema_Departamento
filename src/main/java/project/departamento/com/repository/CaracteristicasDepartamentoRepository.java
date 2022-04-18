package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.departamento.com.entity.CaracteristicasDepartamento;

public interface CaracteristicasDepartamentoRepository extends JpaRepository<CaracteristicasDepartamento, Integer>{

	@Query("select c from CaracteristicasDepartamento c where c.eliminado = 'No'")
	public abstract List<CaracteristicasDepartamento> listarCaracteristicasDepartamento();
	
	
	@Query(value = "{call actualizar_eliminado(:codigoIn, :eliminadoIn)}",nativeQuery = true)
	void eliminarCaracteristicasDepartamento(@Param("codigoIn") int codigoIn, @Param("eliminadoIn") String eliminadoIn);
	
	
	
}
