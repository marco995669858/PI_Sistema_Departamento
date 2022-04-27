package project.departamento.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Usuario;
import project.departamento.com.service.UsuarioService;
import project.departamento.com.util.EncryptPassword;

@Controller
@RequestMapping("/registro/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private EncryptPassword encryptPassword;

	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("user", service.listarUsuarios());
		return "cliente";
	}

	@RequestMapping("/registrar")
	public String registrarUsuario(@RequestParam("codigo") int codigo, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido, @RequestParam("dni") String dni,
			@RequestParam("celular") String celular, @RequestParam("correo") String correo,
			@RequestParam("password") String password, @RequestParam("raza") String raza,
			@RequestParam("descripcionRaza") String descripcionRaza, RedirectAttributes redirect) {

		try {

			Usuario bean = new Usuario();
			bean.setNombreCompleto(nombre);
			bean.setApellidoCompleto(apellido);
			bean.setDni(dni);
			bean.setCelular(celular);
			bean.setCorreo(correo);
			bean.setPasswords(encryptPassword.Encriptar(password));
			bean.setFechaRegistro(new Date());
			bean.setRaza(raza);
			bean.setDescripcionRaza(descripcionRaza);
			bean.setEliminado("No");
			if (codigo != 0) {
				bean.setIdUsuario(codigo);
				service.registrarUsuario(bean);
				redirect.addFlashAttribute("MENSAJE", "Se actualizo el usuario " + nombre + "\n" + apellido);
			} else {
				service.registrarUsuario(bean);
				redirect.addFlashAttribute("MENSAJE", "Se registro el usuario " + nombre + "\n" + apellido);
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "No se registro el usuario " + nombre + "\n" + apellido);
			e.printStackTrace();
		}

		return "redirect:/registro/usuario/";
	}

	@RequestMapping("/buscar")
	@ResponseBody
	public Usuario buscarUsuario(@RequestParam("idUsuario") int codigo) {
		Usuario bean = null;
		try {
			bean = service.buscarUsuario(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}
}
