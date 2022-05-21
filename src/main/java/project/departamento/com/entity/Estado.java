package project.departamento.com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_estado")
@Getter
@Setter
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;
	
	private String Nom_estado;
	
	public Estado(Integer idEstado ) {
		this.idEstado = idEstado;
	}
	
}
