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
@Table(name = "visitante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisitante;

	private String nombres;

	private String apePaterno;

	private String apeMaterno;

	private String dni;

	private String sexo;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
}
