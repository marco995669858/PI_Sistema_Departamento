package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.CaracteristicasDepartamento;
import project.departamento.com.repository.CaracteristicasDepartamentoRepository;

@Service
public class CaracteristicasDepartamentoServiceImpl implements CaracteristicasDepartamentoService{
	
	@Autowired
	private CaracteristicasDepartamentoRepository repository;
	
	@Override
	public List<CaracteristicasDepartamento> listarCaracteristicaDepartamento() {
		
		return  repository.listarCaracteristicasDepartamento();
	}

	@Override
	public void actualizarCaracteristicasDepartamento(CaracteristicasDepartamento bean) {
		
		repository.eliminarCaracteristicasDepartamento(bean.getIdCarateristicadepartamento(), bean.getEliminado());
	}

	@Override
	public CaracteristicasDepartamento registraryactualizarCaracteristicaDepartamento(
			CaracteristicasDepartamento bean) {
		return repository.save(bean);
	}

	@Override
	public List<CaracteristicasDepartamento> BuscarNroDepartamento(int nroDepartamento) {
		return repository.findByNroDepartamento(nroDepartamento);
	}

	@Override
	public List<CaracteristicasDepartamento> listaCaracteristicas() {
		return repository.listaCaracteristicas();
	}

}
