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
@Table(name = "tb_especie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecie;
	
	private String animal;
	
	public Especie(Integer idEspecie) {
		this.idEspecie = idEspecie;
	}

}
