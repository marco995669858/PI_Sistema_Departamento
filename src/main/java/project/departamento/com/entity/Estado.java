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
@Table(name = "tb_estado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;
	
	private String nomEstado;
	
	public Estado(Integer idEstado ) {
		this.idEstado = idEstado;
	}
	
}
