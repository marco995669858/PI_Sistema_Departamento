package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.departamento.com.entity.Mascotas;

public interface MascotasRepository extends JpaRepository<Mascotas, Integer> {

	@Query("select m from Mascotas m where m.idMascotas=?1")
	public Mascotas buscarPorcodigo(int codigo);
}
