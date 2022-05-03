package project.departamento.com.service;



import java.util.List;
import java.util.Optional;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.EspecieMascota;
import project.departamento.com.entity.Mascotas;
import project.departamento.com.entity.Usuario;

public interface MascotasService {
	//Listar Departamentos para Cargar el Combo
	public List<Departamento> listaDepa();
	//Listar Especie para cargar el Combo
	public List<EspecieMascota> listarEspecies();
	//Listar Usuario para cargar el Combo
	public List<Usuario> listarUsuarioNom();
	
	public List<Mascotas> listarMascotas();
	//Registrar y Actualizar Mascotas
	public void registra_actualiza_mascotas(Mascotas mascotas);
	
	public Optional<Mascotas> findByNombre(String nombre);
}
