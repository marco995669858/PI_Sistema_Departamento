package project.departamento.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Rol;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.UsuarioService;
import project.departamento.com.util.EncryptPassword;

@Controller
@RequestMapping("/registro/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	/* para encriptar la contraseña */
	@Autowired
	private EncryptPassword encryptPassword;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("rol", service.listarRoles());
		model.addAttribute("listaUsuario", listarUsuario());
		return "Usuario";
	}

	@GetMapping
	@ResponseBody
	public List<Usuario> listarUsuario() {
		List<Usuario> listaUsuario = service.listarUsuarios();
		return listaUsuario;
	}

	@RequestMapping("/registra_actualiza")
	public String registrar_actualizar_usuario(@RequestParam("codigo") int codigo,
			@RequestParam("nombres") String nombres, @RequestParam("apePaterno") String apePaterno,
			@RequestParam("apeMaterno") String apeMaterno, @RequestParam("user") String user,
			@RequestParam("password") String password, @RequestParam("rol") int rol, RedirectAttributes redirect) {

		try {
			List<Usuario> buscar = service.buscarUser(user);
			if (CollectionUtils.isEmpty(buscar)) {
				Usuario bean = new Usuario();
				bean.setNombres(nombres);
				bean.setApePaterno(apePaterno);
				bean.setApeMaterno(apeMaterno);
				bean.setUser(user);
				bean.setPassword(encryptPassword.Encriptar(password));
				bean.setRol(new Rol(rol));
				
				if (codigo != 0) {
					bean.setIdUsuario(codigo);
					service.registra_actualiza_usuario(bean);
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el nuevo usuario: " + nombres);
				} else {
					service.registra_actualiza_usuario(bean);
					redirect.addFlashAttribute("MENSAJE", "Se registro el nuevo usuario: " + nombres);
				}
			} else {
				redirect.addFlashAttribute("existente", "El correo ya existe ingrese otro: " + user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/registro/usuario/";
	}


}
