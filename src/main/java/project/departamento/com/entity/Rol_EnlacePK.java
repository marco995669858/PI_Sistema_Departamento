package project.departamento.com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
public class Rol_EnlacePK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int idRol;
	private int idEnlace;
}
