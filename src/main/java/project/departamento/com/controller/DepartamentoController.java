package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.departamento.com.service.DepartamentoService;

@Controller
@RequestMapping("/rest/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tipodepartamento", service.listarTipoDepartamento());
		return "departamento";
	}
	
	@RequestMapping("/registrar")
	public String registraActualizaDepartamento(@RequestParam("codigo") int codigo ) {
		 try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 return "redirect:/rest/departamento/";
		
	}
}
