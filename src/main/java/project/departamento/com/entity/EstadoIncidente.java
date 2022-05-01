package project.departamento.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadoincidente")
@Getter
@Setter
@AllArgsConstructor
public class EstadoIncidente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstadoIncidente;
	
	private String descripcion;
	
	
	
}
