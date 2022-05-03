package project.departamento.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Ocupantes;

public interface OcupanteRepository extends JpaRepository<Ocupantes, Integer> {

	/* para buscar si existe el dni,telefono y el correo */
	public Optional<Ocupantes> findByDni(String dni);
	public Optional<Ocupantes> findByCelular(String celular);
	public Optional<Ocupantes> findBySexo(String sexo);
}
