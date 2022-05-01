package project.departamento.com.entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "enlace")
@Getter
@Setter
public class Enlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEnlace;
	
	private String descripcion;
	
	private String ruta;
	
}
