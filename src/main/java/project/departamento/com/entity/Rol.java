package project.departamento.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblRol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	
	private String nombre;
	
	private int estado;
	
	public Rol(int idRol) {
		this.idRol = idRol;
	}
	
}
