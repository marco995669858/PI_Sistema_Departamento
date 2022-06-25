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
@Table(name = "tb_tipoincidentes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoIncidencias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoIncidente;
	
	private String descripcion;
	
	public TipoIncidencias(Integer idTipoIncidente) {
		this.idTipoIncidente = idTipoIncidente;
	}

}
