package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.departamento.com.service.DepartamentoService;

@Controller
@RequestMapping("/registro/departamento")
public class DepartamenoController {
	
	@Autowired
	private DepartamentoService service;
	
	@RequestMapping("/")
	private String index(Model model) {
		model.addAttribute("administrador", service.listaAdministradorNombre());
		return "RegistroDepartamento";
	}
}
