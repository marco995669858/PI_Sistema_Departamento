package project.departamento.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		model.addAttribute("especie", service.listarEspecieMascota());
		model.addAttribute("departamento", service.listarDepartamento());
		model.addAttribute("mascotas", service.listarMascotas());
		return "Mascotas";
	}

	@RequestMapping("/registra_actualiza_mascotas")
	public String registra_actualiza_mascotas(@RequestParam("codigo") int codigo,
			@RequestParam("departamentoFK") int departamentoFK, @RequestParam("nombres") String nombres,
			@RequestParam("especieFK") int especieFK, @RequestParam("sexo") String sexo,
			@RequestParam("usuarioFK") int usuarioFK, RedirectAttributes redirect) {
		try {
			Mascotas bean = new Mascotas();
			bean.setDepartamentoFK(new Departamento(departamentoFK));
			bean.setNombre(nombres);
			bean.setEspecieFK(new EspecieMascota(especieFK));
			bean.setSexo(sexo);
			bean.setEliminado(0);
			bean.setUsuarioFK(new Usuario(usuarioFK));
			bean.setFecharegistro(new Date());
			if (codigo != 0) {
				bean.setIdMascota(codigo);
				service.registra_actualiza_mascotas(bean);
				redirect.addFlashAttribute("MENSAJE", "Se actualizo correctamente la Mascota: " + nombres);
			} else {
				service.registra_actualiza_mascotas(bean);
				redirect.addFlashAttribute("MENSAJE", "Se registro correctamente la Mascota: " + nombres);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/mascotas/";
	}

}
