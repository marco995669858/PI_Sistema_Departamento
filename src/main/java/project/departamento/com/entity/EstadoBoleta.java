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
@Table(name = "estadoboleta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoBoleta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstadoBoleta;
	
	private String descripcion;
}
