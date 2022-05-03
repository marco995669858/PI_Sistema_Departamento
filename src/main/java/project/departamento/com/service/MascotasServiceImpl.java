package project.departamento.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.EspecieMascota;
import project.departamento.com.entity.Mascotas;
import project.departamento.com.entity.Usuario;
import project.departamento.com.repository.DepartamentoRepository;
import project.departamento.com.repository.EspecieRepository;
import project.departamento.com.repository.MascotasRepository;
import project.departamento.com.repository.UsuarioRepository;
@Service
public class MascotasServiceImpl implements MascotasService {
	 @Autowired
	private MascotasRepository repository;
	
	 @Autowired
	private DepartamentoRepository	 deparepository;
	 
	 @Autowired
	private EspecieRepository especierepository;
	 @Autowired
	private UsuarioRepository usuariorepository;
	 
	@Override
	public void registra_actualiza_mascotas(Mascotas mascotas) {
		 repository.save(mascotas);
	}

	@Override
	public List<Departamento> listaDepa() {
		// TODO Auto-generated method stub
		return deparepository.findAll();
	}

	@Override
	public List<EspecieMascota> listarEspecies() {
		// TODO Auto-generated method stub
		return especierepository.findAll();
	}

	@Override
	public List<Usuario> listarUsuarioNom() {
		
		return usuariorepository.findAll();
	}

	@Override
	public Optional<Mascotas> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.findByNombre(nombre);
	}

	@Override
	public List<Mascotas> listarMascotas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
	
}
