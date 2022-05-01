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
@Table(name = "tiposervicio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoServicio;
	
	private String descripcion;

}
