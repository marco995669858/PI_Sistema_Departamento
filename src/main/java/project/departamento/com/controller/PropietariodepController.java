package project.departamento.com.controller;

import java.util.Date;
import java.util.List;

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
		return "";
	}

	@RequestMapping("/registra_actualiza")
	public String registra_actualizar_propietariodep(@RequestParam("codigo") int codigo,
			@RequestParam("nombres") String nombres, @RequestParam("apePaterno") String apePaterno,
			@RequestParam("apeMaterno") String apeMaterno, @RequestParam("dni") String dni,
			@RequestParam("celular") String celular, @RequestParam("correo") String correo,
			@RequestParam("sexo") String sexo, RedirectAttributes redirect) {

		try {

			List<Propietariodep> buscardni = service.buscardni(dni);
			List<Propietariodep> buscarcelular = service.buscarcelular(celular);
			List<Propietariodep> buscarcorreo = service.buscarcorreo(correo);
			if (CollectionUtils.isEmpty(buscardni) && CollectionUtils.isEmpty(buscarcelular)
					&& CollectionUtils.isEmpty(buscarcorreo)) {

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
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el propietario correctamente: " + nombres);
				}

			} else {
				redirect.addFlashAttribute("MENSAJE", "El dni ya exite ingrese otro: " + dni
						+ " o el telefono ya exite ingrese otro:" + celular + " o el correo ya existe: " + correo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/propietariodep/";
	}

}
