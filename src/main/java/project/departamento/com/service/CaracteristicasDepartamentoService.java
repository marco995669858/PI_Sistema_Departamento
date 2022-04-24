package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.CaracteristicasDepartamento;

public interface CaracteristicasDepartamentoService {

	public abstract List<CaracteristicasDepartamento> BuscarNroDepartamento(int nroDepartamento);

	public abstract List<CaracteristicasDepartamento> listarCaracteristicaDepartamento();

	public abstract List<CaracteristicasDepartamento> listaCaracteristicas();

	public abstract CaracteristicasDepartamento registraryactualizarCaracteristicaDepartamento(
			CaracteristicasDepartamento bean);
  
  public abstract void actualizarCaracteristicasDepartamento(CaracteristicasDepartamento bean);
}
