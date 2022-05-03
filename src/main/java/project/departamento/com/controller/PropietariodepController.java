package project.departamento.com.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Propietariodep;
import project.departamento.com.service.PropietariodepService;

@Controller
@RequestMapping("/registro/propietariodep")
public class PropietariodepController {

	@Autowired
	private PropietariodepService service;

	@RequestMapping("/")
	public String index() {
		return "Propietario";
	}

	@RequestMapping("/registra_actualiza")
	public String registra_actualizar_propietariodep(@RequestParam("codigo") int codigo,
			@RequestParam("nombres") String nombres, @RequestParam("apePaterno") String apePaterno,
			@RequestParam("apeMaterno") String apeMaterno, @RequestParam("dni") String dni,
			@RequestParam("celular") String celular, @RequestParam("correo") String correo,
			@RequestParam("sexo") String sexo, RedirectAttributes redirect) {

		try {

			Optional<Propietariodep> buscardni = service.buscardni(dni);
			Optional<Propietariodep> buscarcelular = service.buscarcelular(celular);
			Optional<Propietariodep> buscarcorreo = service.buscarcorreo(correo);
			if (buscardni.isPresent()) {
				redirect.addFlashAttribute("existente", "El dni ya exite ingrese otro: " + dni);
			} else if (buscarcelular.isPresent()) {
				redirect.addFlashAttribute("existente", "El telefono ya exite ingrese otro: " + celular);
			} else if (buscarcorreo.isPresent()) {
				redirect.addFlashAttribute("existente", "El correo ya existe: " + correo);
			} else {
				Propietariodep bean = new Propietariodep();
				bean.setNombres(nombres);
				bean.setApePaterno(apePaterno);
				bean.setApeMaterno(apeMaterno);
				bean.setDni(dni);
				bean.setCelular(celular);
				bean.setCorreo(correo);
				bean.setSexo(sexo);
				bean.setEliminado(0);
				bean.setFechaRegistro(new Date());

				if (codigo != 0) {
					bean.setIdPropietario(codigo);
					service.registra_actualiza_propietario(bean);
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el propietario correctamente: " + nombres);
				} else {
					service.registra_actualiza_propietario(bean);
					redirect.addFlashAttribute("MENSAJE", "Se registro el propietario correctamente: " + nombres);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/propietariodep/";
	}

}
