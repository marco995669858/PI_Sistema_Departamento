package project.departamento.com.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rol_enlace")
@Getter
@Setter
public class Rol_Enlace {

	@EmbeddedId
	private Rol_EnlacePK rol_EnlacePK;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "idEnlace", nullable = false, insertable = false, updatable = false)
	private Enlace enlace;
}
