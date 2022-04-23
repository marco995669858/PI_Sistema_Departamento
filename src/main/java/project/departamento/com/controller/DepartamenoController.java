package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.departamento.com.service.DepartamentoService;
import project.departamento.com.service.EdificioService;
import project.departamento.com.service.UsuarioService;

@Controller
@RequestMapping("/registro/departamento")
public class DepartamenoController {
	
	@Autowired
	private DepartamentoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EdificioService edificioService;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("admin", usuarioService.obtieneAdministrador());
		model.addAttribute("edificio", edificioService.listarEdificio());
		return "RegistroDepartamento";
	}
	
//	@GetMapping
//	@ResponseBody
//	public String obtiene() {
//		return usuarioService.obtieneAdministrador();
//	}
}
