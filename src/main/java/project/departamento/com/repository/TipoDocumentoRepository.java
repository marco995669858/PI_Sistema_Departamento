package project.departamento.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.departamento.com.entity.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

}
