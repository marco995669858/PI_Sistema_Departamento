package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.EspecieMascota;

public interface TipoMascotaRepository extends JpaRepository<EspecieMascota, Integer>{

}
