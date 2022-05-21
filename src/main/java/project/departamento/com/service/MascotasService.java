package project.departamento.com.service;

import java.util.List;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.EspecieMascota;
import project.departamento.com.entity.Mascotas;

public interface MascotasService {
	
	public List<EspecieMascota> listarEspecieMascota();
	
	public List<Departamento> listarDepartamento();
	
	public List<Mascotas> listarMascotas();
	
	public void registra_actualiza_mascotas(Mascotas bean);
	
}
