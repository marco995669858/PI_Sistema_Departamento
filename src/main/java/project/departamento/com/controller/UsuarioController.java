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

@Controller
@RequestMapping("/res/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("rol", service.listarRoles());
		model.addAttribute("listaUsuario", service.listarTodosLosUsuario());
		return "usuario";
	}

	@RequestMapping("/registrar")
	public String registraActualizaUsaurio(@RequestParam("codigo") int codigo,
			@RequestParam("nomUsuario") String nombreUsuario, @RequestParam("nombres") String nombres,
			@RequestParam("apePaterno") String apePaterno, @RequestParam("apeMaterno") String apeMaterno,
			@RequestParam("cuentaUsuario") String correo, @RequestParam("password") String password,
			@RequestParam("telefono") String telefono, @RequestParam("rol") int rol, RedirectAttributes redirect) {
		
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
				registro.setPasswordUsuario(password);
				registro.setTelefono(telefono);
				registro.setRol(new Rol(rol));
				registro.setFechaRegistro(new Date());
				registro.setEliminado(0);
				if (codigo != 0) {
					registro.setIdUsuario(codigo);
					service.registrarActualizaUsuario(registro);
					redirect.addFlashAttribute("MENSAJE", "Se registro el usuario correctamente");
				} else {
					service.registrarActualizaUsuario(registro);
					redirect.addFlashAttribute("MENSAJE", "Se registro el usuario correctamente");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/res/usuario/";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {
		
		try {
			Usuario bean = service.buscarUsarioPorCodigo(codigo);
			bean.setEliminado(0);
			service.eliminarUsuario(bean);
			redirect.addFlashAttribute("MENSAJE","Visitante eliminado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/rest/usuario/";
	}
}
