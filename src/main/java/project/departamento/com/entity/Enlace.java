package project.departamento.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_enlace")
@Getter
@Setter
public class Enlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEnlace;
	
	private String Descripcion;
	
	private String Ruta;
}
