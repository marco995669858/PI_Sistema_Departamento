package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.departamento.com.entity.CaracteristicasDepartamento;
import project.departamento.com.entity.Usuario;

public interface LoginRepository  extends JpaRepository<CaracteristicasDepartamento, Integer> {
	/*select * from tblusuario where correo = 'fenixxd23@gmail.com';
	 * 
	 * @Query("Select x from Usuario x where x.login = :#{#usu.login} and x.password = :#{#usu.password}")
	 * 
	 * 
	 * */
	@Query("select u from Usuario u where u.correo = Correo")
	public abstract Usuario BuscarUsuario(@Param("Correo") String correo);
	
	
	
	
}
