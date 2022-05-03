package project.departamento.com.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.EspecieMascota;
import project.departamento.com.entity.Mascotas;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.MascotasService;



@Controller
@RequestMapping("/registro/mascotas")
public class MascotasController {
	@Autowired
	private MascotasService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listaMascotas",listarMascotas());
//		model.addAttribute("departamento", service.listaDepa());
//		model.addAttribute("especiemascota", service.listarEspecies());
//		model.addAttribute("usuario",service.listarUsuarioNom());
		return "Mascotas";
	}
	
	@GetMapping("/listar")
	@ResponseBody
	public List<Mascotas> listarMascotas() {
		List<Mascotas> listaMascotas = service.listarMascotas();
		return listaMascotas;
	}
//	
//	@RequestMapping("/registra_actualiza_mascotas")
//	public String registra_actualiza_mascotas(@RequestParam("codigo") int codigo,
//			@RequestParam("departamentoFK") int departamentoFK, @RequestParam("nombres") String nombres,
//			@RequestParam("especieFK") int especieFK, @RequestParam("sexo") String sexo,
//			@RequestParam("usuarioFK") int usuarioFK,
//			RedirectAttributes redirect) {
//		try {
//
//			Optional<Mascotas> buscarNombre = service.findByNombre(nombres);
//		
//
//			if (buscarNombre.isPresent()) {
//				redirect.addFlashAttribute("existente", "El nombre ya existe: " + nombres);
//			}
//			else {
//				Mascotas bean = new Mascotas();
//				bean.setDepartamentoFK(new Departamento());
//				bean.setNombre(nombres);
//				bean.setEspecieFK(new EspecieMascota());
//				bean.setSexo(sexo);
//				bean.setEliminado(0);
//				bean.setUsuarioFK(new Usuario());
//				bean.setFechaRegistro(new Date());
//				if (codigo != 0) {
//					bean.setIdMascota(codigo);
//					service.registra_actualiza_mascotas(bean);
//					redirect.addFlashAttribute("MENSAJE",
//							"Se actualizo correctamente la Mascota: " + nombres);
//				} else {
//					service.registra_actualiza_mascotas(bean);
//					redirect.addFlashAttribute("MENSAJE",
//							"Se registro correctamente la Mascota: " + nombres);
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return "redirect:/registro/mascotas/";
//	}
}
