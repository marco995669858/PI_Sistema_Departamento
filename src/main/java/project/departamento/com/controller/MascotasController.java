package project.departamento.com.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.departamento.com.service.MascotasService;



@Controller
@RequestMapping("/registro/mascotas")
public class MascotasController {
//	@Autowired
//	private MascotasService service;
	@RequestMapping("/")
	public String index(Model model) {
	
		return "Mascotas";
}
}
