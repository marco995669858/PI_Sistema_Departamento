package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.CaracteristicasDepartamento;

public interface CaracteristicasDepartamentoService {

	
	public abstract CaracteristicasDepartamento registraryactualizarCaracteristicaDepartamento(CaracteristicasDepartamento bean);

   public abstract List<CaracteristicasDepartamento> listarCaracteristicaDepartamento();
	
	public abstract void actualizarCaracteristicasDepartamento(CaracteristicasDepartamento bean);
}
