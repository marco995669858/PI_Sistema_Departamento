package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.service.VisitanteService;

@Controller
@RequestMapping("/rest/visitante")
public class VisitanteController {

	@Autowired
	private VisitanteService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tabla", service.listarTodoslosVisitantes());

		return "visitante";
	}

	@RequestMapping("/registrar")
	public String registraActualizaVisitante(@RequestParam("codigo") int codigo,
			@RequestParam("idDepartamento") int idDepartamento, @RequestParam("Nombres") int nombres,
			@RequestParam("Apellidos") int apellidos, @RequestParam("idTipoDocumento") int idTipoDocumento,
			@RequestParam("Documento") int documento, @RequestParam("telefono") int telefono,
			@RequestParam("correo") int correo, @RequestParam("idCliente") int idCliente, RedirectAttributes redirect) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
