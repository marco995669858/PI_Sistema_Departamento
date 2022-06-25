package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.service.IncidenciasService;

@Controller
@RequestMapping("/rest/incidencias")
public class IncidenciasController {

	@Autowired
	private IncidenciasService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("comTipIncidencias", service.listarTipoIncidencias());
		return "incidencias";
	}

	@RequestMapping("/registrar")
	public String registrarIncidencias(@RequestParam("tipoIncidencias") int tipoIncidencias,@RequestParam("departamento") int departamento, 
									   @RequestParam("comentario") String comentario,@RequestParam("cliente") int cliente,RedirectAttributes redirect) {
		return "redirect:/rest/incidencias/";
	}
}
