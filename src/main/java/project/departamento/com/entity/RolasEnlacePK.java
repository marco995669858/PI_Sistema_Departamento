package project.departamento.com.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RolasEnlacePK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idRol;
	
	private int idEnlace;
	
	@Override
	public int hashCode() {
		return Objects.hash(idEnlace, idRol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolasEnlacePK other = (RolasEnlacePK) obj;
		return idEnlace == other.idEnlace && idRol == other.idRol;
	}
}
