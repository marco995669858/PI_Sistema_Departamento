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
@Table(name = "tblSubMenu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubMenu;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMenu")
	private SubMenu subMenu;
	
	private String nombre;
	
	private String ruta;
	
	private int estado;
}
