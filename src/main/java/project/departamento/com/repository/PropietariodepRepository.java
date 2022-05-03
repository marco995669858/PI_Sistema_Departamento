package project.departamento.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Propietariodep;

public interface PropietariodepRepository extends JpaRepository<Propietariodep, Integer> {

	/* para buscar si existe el dni,telefono y el correo */
	public Optional<Propietariodep> findByDni(String dni);
	public Optional<Propietariodep> findByCelular(String celular);
	public Optional<Propietariodep> findByCorreo(String correo);
}
