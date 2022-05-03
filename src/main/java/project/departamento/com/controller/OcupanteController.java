package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.departamento.com.service.DepartamentoService;
import project.departamento.com.service.OcupanteService;

@Controller
@RequestMapping("/registro/ocupante")
public class OcupanteController {

	@Autowired
	private OcupanteService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("departamento", service.listarDepartamentos());
		model.addAttribute("tipodepartamento", service.listarRelacionconPropietario());
		return "departamento";
	}
}