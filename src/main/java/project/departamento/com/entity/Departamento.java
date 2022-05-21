package project.departamento.com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_departamento")
@Getter
@Setter
public class Departamento {
	
	
	private Integer idDepartamento;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipo")
	private TipoDepartamento tipoDepartamento;
	
	private String Piso;
	
	private String NroDepartamento;
	
	private int NroHabitaciones;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	private Date Fecharegistro;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstado")
	private Estado estado;
	
	private int Eliminado;
	
	public Departamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	

}
