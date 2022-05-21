package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.EspecieMascota;
import project.departamento.com.entity.Mascotas;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.MascotasRepository;
import project.departamento.com.repository.TipoMascotaRepository;

@Service
public class MascotasServiceImpl implements MascotasService {

	@Autowired
	private MascotasRepository repository;
	
	@Autowired
	private TipoMascotaRepository reMascotaRepository;
	
	@Autowired
	private DepartamentoRepository repositoryDepartamentoRepository;
	
	@Override
	public void registra_actualiza_mascotas(Mascotas bean) {
		repository.save(bean);
	}

	@Override
	public List<EspecieMascota> listarEspecieMascota() {
		return reMascotaRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamento() {
		return repositoryDepartamentoRepository.findAll();
	}

	@Override
	public List<Mascotas> listarMascotas() {
		return repository.findAll();
	}

}
