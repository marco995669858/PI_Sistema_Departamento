package project.departamento.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Especie;
import project.departamento.com.entity.Mascotas;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.EspecieRepository;
import project.departamento.com.repository.MascotasRepository;

@Service
public class MascotasServiceImpl implements MascotaService {
	
	@Autowired
	private MascotasRepository repository;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public List<Mascotas> listarMascotas() {
		return repository.findAll();
	}

	@Override
	public Mascotas registraActualizaMascota(Mascotas bean) {
		return repository.save(bean);
	}

	@Override
	public void eliminarMascotas(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public Mascotas buscarMascotasporID(Integer codigo) {
		return repository.buscarPorcodigo(codigo);
	}

	@Override
	public List<Especie> listarEspecies() {
		return especieRepository.findAll();
	}

	@Override
	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}

}
