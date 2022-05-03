package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Ocupantes;

public interface OcupanteRepository extends JpaRepository<Ocupantes, Integer> {

}
