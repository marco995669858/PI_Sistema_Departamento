package project.departamento.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.CaracteristicasDepartamento;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Edificio;
import project.departamento.com.entity.Rol;
import project.departamento.com.service.CaracteristicasDepartamentoService;
import project.departamento.com.service.DepartamentoService;
import project.departamento.com.service.EdificioService;
import project.departamento.com.service.UsuarioService;

//@RestController
@Controller
@RequestMapping("/registro/departamento")
public class DepartamenoController {

	@Autowired
	private DepartamentoService service;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EdificioService edificioService;

	@Autowired
	private CaracteristicasDepartamentoService departamentoService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("admin", usuarioService.obtieneAdministrador());
		model.addAttribute("edificio", edificioService.listarEdificio());
		model.addAttribute("nro", obtiene());
		return "RegistroDepartamento";
	}

	@RequestMapping("/registrar")
	public String registrarActualizarDepartamento(@RequestParam("codigo") int codigo,
			@RequestParam("nroDepartamento") int nroDepartamento, RedirectAttributes redirect) {

		try {
			Departamento register = new Departamento();
			register.setAdministrador(new Rol(1000));
			register.setEdificio(new Edificio(1000));
			register.setCaracteristicasDepartamento(new CaracteristicasDepartamento(nroDepartamento));
			if (codigo != 0) {
				register.setIdDepartamento(codigo);
				service.registraActualizaDepartamento(register);
				redirect.addFlashAttribute("MENSAJE", "Se registro el departamento con el numero: " + nroDepartamento);
			} else {
				service.registraActualizaDepartamento(register);
				redirect.addFlashAttribute("MENSAJE", "Se registro el departamento con el numero");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/departamento/";
	}

	@GetMapping
	@ResponseBody
	public List<CaracteristicasDepartamento> obtiene() {
		return departamentoService.listaCaracteristicas();
	}
}
