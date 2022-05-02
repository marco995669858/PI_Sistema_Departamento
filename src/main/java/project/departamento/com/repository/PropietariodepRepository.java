package project.departamento.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Propietariodep;

public interface PropietariodepRepository extends JpaRepository<Propietariodep, Integer> {

	/* para buscar si existe el dni,telefono y el correo */
	public List<Propietariodep> findByDni(String dni);
	public List<Propietariodep> findByCelular(String celular);
	public List<Propietariodep> findByCorreo(String correo);
}
