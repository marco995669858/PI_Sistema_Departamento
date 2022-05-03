package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.EspecieMascota;

public interface EspecieRepository extends JpaRepository<EspecieMascota, Integer> {

}
