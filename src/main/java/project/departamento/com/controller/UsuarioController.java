package project.departamento.com.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.UsuarioService;
import project.departamento.com.util.EncryptPassword;

@Controller
@RequestMapping("/rest/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private EncryptPassword encriptar;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("rol", service.listarRoles());
		model.addAttribute("listaUsuario", service.listarTodosLosUsuarioActivos(1));
		return "usuario";
	}

	@RequestMapping("/registrar")
	public String registraActualizaUsaurio(@RequestParam("nomUsuario") String nombreUsuario,
			@RequestParam("nombres") String nombres, @RequestParam("apePaterno") String apePaterno,
			@RequestParam("apeMaterno") String apeMaterno, @RequestParam("cuentaUsuario") String correo,
			@RequestParam("password") String password, @RequestParam("telefono") String telefono,
			@RequestParam("rol") int rol, RedirectAttributes redirect) {

		try {

			Optional<Usuario> buscarCorreo = service.buscarCorreo(correo);
			Optional<Usuario> buscarTelefono = service.buscarTelefono(telefono);

			if (buscarCorreo.isPresent()) {
				redirect.addFlashAttribute("existen", "El correo que ingreso ya exite " + correo + " ingrese otro.");
			} else if (buscarTelefono.isPresent()) {
				redirect.addFlashAttribute("existen",
						"El tefelono que ingreso ya exites" + telefono + " ingrese otro.");
			} else {
				Usuario registro = new Usuario();
				registro.setNomUsuario(nombreUsuario);
				registro.setNombres(nombres);
				registro.setApePaterno(apePaterno);
				registro.setApeMaterno(apeMaterno);
				registro.setCuentaUsuario(correo);
				registro.setPasswordUsuario(encriptar.Encriptar(password));
				registro.setTelefono(telefono);
				registro.setRol(new Rol(rol));
				registro.setFechaRegistro(new Date());
				registro.setEliminado(1);
				service.registrarActualizaUsuario(registro);
				redirect.addFlashAttribute("MENSAJE", "Se registro el usuario correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/usuario/";
	}

	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {

		try {
			service.eliminarUsuario(codigo);
			redirect.addFlashAttribute("MENSAJE", "Usuario eliminado");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/usuario/";
	}
}
