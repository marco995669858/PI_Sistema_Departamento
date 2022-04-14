package project.departamento.com.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblServicios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicios;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepartamento")
	private Departamento departamento;
	
	private String mes;
	
	private double montoDepartamento;
	
	private double luz;
	
	private double agua;
	
	private double mantenimiento;
}
