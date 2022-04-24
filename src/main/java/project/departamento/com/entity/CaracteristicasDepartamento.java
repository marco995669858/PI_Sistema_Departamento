package project.departamento.com.entity;

import java.util.List;

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
public class CaracteristicasDepartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarateristicadepartamento;
	
	private int nroDepartamento;

	private int habitaciones;

	private String cocinaComedor;

	private String lavanderia;

	private int sala;

	private int banio;

	private String tamanio;

	private String eliminado;
	
	public CaracteristicasDepartamento() {
		super();
	}

	
	public CaracteristicasDepartamento(int idCarateristicadepartamento) {
		this.idCarateristicadepartamento = idCarateristicadepartamento;
	}

	public CaracteristicasDepartamento(int idCarateristicadepartamento, int nroDepartamento, int habitaciones,
			String cocinaComedor, String lavanderia, int sala, int banio, String tamanio, String eliminado) {
		this.idCarateristicadepartamento = idCarateristicadepartamento;
		this.nroDepartamento = nroDepartamento;
		this.habitaciones = habitaciones;
		this.cocinaComedor = cocinaComedor;
		this.lavanderia = lavanderia;
		this.sala = sala;
		this.banio = banio;
		this.tamanio = tamanio;
		this.eliminado = eliminado;
	}

}
