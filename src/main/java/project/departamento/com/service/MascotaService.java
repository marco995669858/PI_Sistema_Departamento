package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Especie;
import project.departamento.com.entity.Mascotas;

public interface MascotaService {
	
	public List<Departamento> listarDepartamentos();
	
	public abstract List<Especie> listarEspecies();
	
	public abstract List<Mascotas> listarMascotas();
	
	public abstract Mascotas buscarMascotasporID(Integer codigo);

	public abstract Mascotas registraActualizaMascota(Mascotas bean);

	public abstract void eliminarMascotas(Integer codigo);

}
