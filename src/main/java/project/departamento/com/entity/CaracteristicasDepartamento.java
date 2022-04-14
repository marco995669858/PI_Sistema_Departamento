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
@Table(name = "tblCaracteristicasDepartamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaracteristicasDepartamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarateristicadepartamento;

	private int habitaciones;

	private String cocinaComedor;

	private String lavanderia;

	private int sala;

	private int banio;

	private String tamanio;

	private String eliminado;

}
