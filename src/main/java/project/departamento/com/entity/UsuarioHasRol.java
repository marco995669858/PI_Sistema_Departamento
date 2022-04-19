package project.departamento.com.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblUsuarioHasRol")
public class UsuarioHasRol {
	
	@EmbeddedId
	private UsuarioHasRolPK usuarioHasRolPk;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol;
	
	
}
