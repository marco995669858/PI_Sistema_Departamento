package project.departamento.com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "propietariodep")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propietariodep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPropietario;

	private String nombres;

	private String apePaterno;

	private String apeMaterno;
	
	private String dni;

	private String celular;
	
	private String correo;

	private String sexo;
	
	private int eliminado;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
	
	public Propietariodep(int idPropietario) {
		this.idPropietario = idPropietario;
	}
}
