package project.departamento.com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipoDocumento")
@Getter
@Setter
@AllArgsConstructor
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoDocumento;
	
	private String Descripcion;
	
	public TipoDocumento(Integer idTipoDocumento){
		this.idTipoDocumento = idTipoDocumento;
	}
}
