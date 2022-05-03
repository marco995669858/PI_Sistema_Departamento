package project.departamento.com.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Ocupantes;
import project.departamento.com.service.OcupanteService;

@Controller
@RequestMapping("/registro/ocupante")
public class OcupanteController {

	@Autowired
	private OcupanteService service;
	/*@Autowired
	private DepartamentoService departamentoService;*/
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("departamento", service.listarDepartamentos());
		model.addAttribute("relacioncondepartamento", service.listarRelacionconPropietario());
		return "ocupantes";
	}
	
	@RequestMapping("/registra_actualiza_ocupante")
	public String registra_actualizar_propietariodep(@RequestParam("codigo") int codigo,
			@RequestParam("nombres") String nombres, @RequestParam("apePaterno") String apePaterno,
			@RequestParam("apeMaterno") String apeMaterno, @RequestParam("dni") String dni,
			@RequestParam("celular") String celular, @RequestParam("sexo") String sexo,
			 RedirectAttributes redirect) {
		try {

			Optional<Ocupantes> buscardni = service.buscardni(dni);
			Optional<Ocupantes> buscarcelular = service.buscarcelular(celular);
			Optional<Ocupantes> buscarsexo = service.buscarsexo(sexo);
			if (buscardni.isPresent()) {
				redirect.addFlashAttribute("existente", "El dni ya exite ingrese otro: " + dni);
			} else if (buscarcelular.isPresent()) {
				redirect.addFlashAttribute("existente", "El telefono ya exite ingrese otro: " + celular);
			} else if (buscarsexo.isPresent()) {
				redirect.addFlashAttribute("existente", "El correo ya existe: " + sexo);
			} else {
				Ocupantes bean = new Ocupantes();
				bean.setNombres(nombres);
				bean.setApePaterno(apePaterno);
				bean.setApeMaterno(apeMaterno);
				bean.setDni(dni);
				bean.setCelular(celular);
				bean.setSexo(sexo);
				bean.setEliminado(0);
				bean.setFechaRegistro(new Date());

				if (codigo != 0) {
					bean.setIdOcupante(codigo);
					service.registra_actualiza_ocupante(bean);
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el ocupante correctamente: " + nombres);
				} else {
					service.registra_actualiza_ocupante(bean);
					redirect.addFlashAttribute("MENSAJE", "Se registro el ocupante correctamente: " + nombres);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/ocupante/";
	}
	
	}
	