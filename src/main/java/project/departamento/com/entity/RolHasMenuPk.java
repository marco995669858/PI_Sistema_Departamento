package project.departamento.com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RolHasMenuPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idRol;
	
	private int idMenu;

}
