package project.departamento.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.departamento.com.entity.Visitante;
import project.departamento.com.service.ControlVisitaService;
import project.departamento.com.service.VisitanteService;

@Controller
@RequestMapping("/rest/controlvisita")
public class ControlVisitaController {

	@Autowired
	private ControlVisitaService service;
	
	@Autowired
	private VisitanteService  visitanteService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("comboVisitante", service.listarVisitanteCombo());
		return "VisitaIngreso";
	}

	@GetMapping(value = "/buscardni")
	@ResponseBody
	public List<Visitante> buscar(@RequestParam("dni") String dni) {
		List<Visitante> bean = null;
		try {
			bean = visitanteService.buscarVisitantepordni(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
