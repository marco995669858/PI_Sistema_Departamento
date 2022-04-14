package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
