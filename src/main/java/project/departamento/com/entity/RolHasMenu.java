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
@Table(name = "tblrolHasMenu")
public class RolHasMenu {
	
	@EmbeddedId
	private RolHasMenuPk rolhasmenuPk;
	
	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "idMenu", nullable = false, insertable = false, updatable = false)
	private Menu menu;

}
