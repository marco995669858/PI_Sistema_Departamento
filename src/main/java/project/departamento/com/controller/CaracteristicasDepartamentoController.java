package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.CaracteristicasDepartamento;
import project.departamento.com.service.CaracteristicasDepartamentoService;

@Controller
@RequestMapping("/registro/caracteristica_Departamento")
public class CaracteristicasDepartamentoController {

	@Autowired
	private CaracteristicasDepartamentoService service;

	@RequestMapping(value = "/registrar/")
	public String registrarCaracteristicasDepartamento(@RequestParam("codigo") int codigo,
			@RequestParam("habitaciones") int habitaciones, @RequestParam("cocina") String cocina,
			@RequestParam("lavanderia") String lavanderia, @RequestParam("sala") int sala,
			@RequestParam("banio") int banio, @RequestParam("tamanio") String tamanio, RedirectAttributes redirect) {
		try {
			CaracteristicasDepartamento bean = new CaracteristicasDepartamento();
			bean.setHabitaciones(habitaciones);
			bean.setCocinaComedor(cocina);
			bean.setLavanderia(lavanderia);
			bean.setSala(sala);
			bean.setBanio(banio);
			bean.setTamanio(tamanio);
			String eliminado = "No";
			bean.setEliminado(eliminado);
			if (codigo == 0) {

				service.registraryactualizarCaracteristicaDepartamento(bean);
				redirect.addFlashAttribute("MENSAJE",
						"Se registro el departamento correctamente, con el codigo: "
								+ bean.getIdCarateristicadepartamento());
			}
			else {
				bean.setIdCarateristicadepartamento(codigo);
				service.registraryactualizarCaracteristicaDepartamento(bean);
				redirect.addFlashAttribute("MENSAJE", "Se actualizo el departamento correctamente, con el codigo: "
						+ bean.getIdCarateristicadepartamento());
			}

		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en registrar los datos de caracteristicas del departamento.");
			e.printStackTrace();
		}

		return "redirect:/Registro/Departamento";
	}

	@GetMapping("/eliminar/{idCarateristicadepartamento}")
	public String eliminarCaractDepartamento(
			@PathVariable(value = "idCarateristicadepartamento") int idCarateristicadepartamento,
			RedirectAttributes redirect) {

		try {
			CaracteristicasDepartamento bean = new CaracteristicasDepartamento();
			String eliminar = "Si";
			bean.setEliminado(eliminar);
			bean.setIdCarateristicadepartamento(idCarateristicadepartamento);
			service.actualizarCaracteristicasDepartamento(bean);
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE",
					"Se elimino las caracteristicas del departamento con el codigo: " + idCarateristicadepartamento);
			e.printStackTrace();
		}

		return "redirect:/Registro/departamento";
	}

}
