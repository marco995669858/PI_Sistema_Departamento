package project.departamento.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Residente;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.DepartamentoService;
import project.departamento.com.service.ResidenteService;
import project.departamento.com.service.UsuarioService;

@Controller
@RequestMapping("/registro/residente")
public class ResidenteController {

	@Autowired
	private ResidenteService service;

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("depa", departamentoService.listarDepartamento());
		model.addAttribute("user", usuarioService.listarUsuariosDistintodelAdministrador());
		return "RegistroResidente";
	}

	@RequestMapping("/registrarResidente")
	public String registrarResidente(@RequestParam("codigo") int codigo,
			@RequestParam("idDepartamento") int idDepartamento, @RequestParam("usuario") int usuario,
			@RequestParam("fechaSalida") String fechaSalida, RedirectAttributes redirect) {
		try {
//			List<Residente> buscar = service.buscarDepartamento(idDepartamento);
//			List<Residente> buscar2 = service.buscarUsuario(usuario);
//			if (CollectionUtils.isEmpty(buscar) && CollectionUtils.isEmpty(buscar2)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Residente bean = new Residente();
				bean.setDepartamento(new Departamento(idDepartamento));
				bean.setUsuario(new Usuario(usuario));
				bean.setFechaIngreso(new Date());
				bean.setFechasalidad(sdf.parse(fechaSalida));
				if (codigo != 0) {
					bean.setIdResidente(codigo);
					service.RegistrarActualizaResidente(bean);
					redirect.addFlashAttribute("MENSAJE", "Se registro el rediente correctamente.");
				} else {
					service.RegistrarActualizaResidente(bean);
					redirect.addFlashAttribute("MENSAJE", "Se registro el rediente correctamente.");
				}
//			} else {
//				redirect.addFlashAttribute("x", "El departamento ya esta asociado a un residente:" + idDepartamento
//						+ ' ' + "el usuario ya esta asociado a un residente: " + usuario);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/residente/";
	}

}
