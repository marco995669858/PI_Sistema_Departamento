package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.departamento.com.service.UsuarioService;

@Controller
@RequestMapping("/registro/usuario")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService service;
}
