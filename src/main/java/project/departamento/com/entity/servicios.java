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
@Table(name = "tb_servicios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class servicios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServicios;
	
	private String tipodeServicio;
	
	public servicios(Integer idServicios) {
		this.idServicios = idServicios;
	}
	

}
