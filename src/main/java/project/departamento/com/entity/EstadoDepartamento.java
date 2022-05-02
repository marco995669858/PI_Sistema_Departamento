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
@Table(name = "estadodepartamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDepartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstado;
	
	private String descripcion;
	
	public EstadoDepartamento(int idEstado) {
		this.idEstado = idEstado;
	}

}
