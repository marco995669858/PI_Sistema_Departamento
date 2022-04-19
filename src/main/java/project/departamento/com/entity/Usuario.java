package project.departamento.com.entity;

import java.util.Date;

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
@Table(name = "tblUsuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	private String nombreCompleto;
	
	private String apellidoCompleto;
	
	private String dni;
	
	private String celular;
	
	private String correo;
	
	private String passwords;
	
	private Date fechaRegistro;
	
	private String raza;
	
	private String descripcionRaza;
	
	private String eliminado;
	
}
