package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String index() {
		return "visitante";
	}

	@RequestMapping("/registrar")
	public String registraActualizaVisitante(@RequestParam("codigo") int codigo,
			@RequestParam("nombreArchivo") int nombreArchivo, @RequestParam("idDepartamento") int idDepartamento,
			@RequestParam("nombres") int nombres, @RequestParam("apellidos") int apellidos,
			@RequestParam("idTipoDocumento") int idTipoDocumento, @RequestParam("documento") int documento,
			@RequestParam("telefono") int telefono, @RequestParam("correo") int correo,
			@RequestParam("idCliente") int idCliente, RedirectAttributes redirect) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
