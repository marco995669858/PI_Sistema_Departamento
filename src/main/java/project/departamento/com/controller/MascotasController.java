package project.departamento.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Especie;
import project.departamento.com.entity.Mascotas;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.MascotaService;

@Controller
@RequestMapping("/rest/mascotas")
public class MascotasController {

	@Autowired
	private MascotaService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("mascotas", service.listarMascotas());
		model.addAttribute("especie", service.listarEspecies());
		model.addAttribute("departamento", service.listarDepartamentos());
		return "mascotas";
	}


	@RequestMapping("/registrar")
	public String registrarActualizarMascotas(@RequestParam("codigo") int codigo,
			@RequestParam("nroDepartamento") int departamento, @RequestParam("nombres") String nombre,
			@RequestParam("especie") int especie,@RequestParam("usuario") int usuario, RedirectAttributes redirect) {
		try {

			Mascotas bean = new Mascotas();
			bean.setDepartamento(new Departamento(departamento));
			bean.setNombres(nombre);
			bean.setEspecie(new Especie(especie));
			bean.setUsuario(new Usuario(usuario));
			bean.setFechaRegistro(new Date());
			if (codigo != 0) {
				bean.setIdMascotas(codigo);
				service.registraActualizaMascota(bean);
				redirect.addFlashAttribute("MENSAJE", "Se Actualizo la mascota exitosamente");
			} else {
				service.registraActualizaMascota(bean);
				redirect.addFlashAttribute("MENSAJE", "Se registro la mascota exitosamente");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/mascotas/";
	}

	@RequestMapping("/eliminar")
	public String eliminarMascota(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {

		try {
			service.eliminarMascotas(codigo);
			redirect.addFlashAttribute("MENSAJE", "Se eliminó la mascota");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/mascotas/";
	}

	@RequestMapping("/buscar")
	@ResponseBody
	public Mascotas buscarMascota(@RequestParam("codigo") int codigo) {
		Mascotas bean = null;
		try {
			bean = service.buscarMascotasporID(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}
}
