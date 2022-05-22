package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Mascotas;

public interface MascotasRepository extends JpaRepository<Mascotas, Integer>{
	

}
