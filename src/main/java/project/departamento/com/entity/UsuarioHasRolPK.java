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
public class UsuarioHasRolPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int idUsuario;
	private int idRol;
}
