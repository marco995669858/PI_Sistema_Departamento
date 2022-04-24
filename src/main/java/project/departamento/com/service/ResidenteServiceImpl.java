package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Residente;
import project.departamento.com.repository.ResidenteRepository;

@Service
public class ResidenteServiceImpl implements ResidenteService{

	@Autowired
	private ResidenteRepository repository;
	
	@Override
	public void RegistrarActualizaResidente(Residente bean) {
		repository.save(bean);
	}


//	@Override
//	public List<Residente> buscarDepartamento(int idDepartamento) {
//		return repository.buscarDepartamento(idDepartamento);
//	}
//
//	@Override
//	public List<Residente> buscarUsuario(int idUsuario) {
//		return repository.buscarUsuario(idUsuario);
//	}

}
