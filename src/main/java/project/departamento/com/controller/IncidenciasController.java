package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.departamento.com.service.IncidenciasService;

@Controller
@RequestMapping("/rest/incidencias")
public class IncidenciasController {

	@Autowired
	private IncidenciasService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		return "incidencias";
	}
}
