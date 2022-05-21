package project.departamento.com.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_rol_enlace")
@Getter
@Setter
public class RolasEnlace {
	
	@EmbeddedId
	private RolasEnlacePK rolasEnlacePK;
	
	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol; 

	@ManyToOne
	@JoinColumn(name = "idEnlace", nullable = false, insertable = false, updatable = false)
	private Enlace enlace;

}
