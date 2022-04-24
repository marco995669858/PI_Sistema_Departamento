package project.departamento.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.CaracteristicasDepartamento;
import project.departamento.com.service.CaracteristicasDepartamentoService;

@Controller
public class CaracteristicasDepartamentoController {

	@Autowired
	private CaracteristicasDepartamentoService service;


	@RequestMapping("/registro/caracteristica_Departamento")
	public String Index(Model model) {
		model.addAttribute("depa", service.listarCaracteristicaDepartamento());
		return "departamento";
	}

	@RequestMapping("/registrar/")
	public String registrarCaracteristicasDepartamento(@RequestParam("codigo") int codigo,
			@RequestParam("nroDepartamento") int nroDepartamento, @RequestParam("habitaciones") int habitaciones,
			@RequestParam("cocina") String cocina, @RequestParam("lavanderia") String lavanderia,
			@RequestParam("sala") int sala, @RequestParam("banio") int banio, @RequestParam("tamanio") String tamanio,
			RedirectAttributes redirect) {
		try {
			CaracteristicasDepartamento bean = new CaracteristicasDepartamento();
			bean.setNroDepartamento(nroDepartamento);
			bean.setHabitaciones(habitaciones);
			bean.setCocinaComedor(cocina);
			bean.setLavanderia(lavanderia);
			bean.setSala(sala);
			bean.setBanio(banio);
			bean.setTamanio(tamanio);
			String eliminado = "No";
			bean.setEliminado(eliminado);
			List<CaracteristicasDepartamento> buscar = service.BuscarNroDepartamento(nroDepartamento);
			if (CollectionUtils.isEmpty(buscar)) {
				if (codigo == 0) {
					service.registraryactualizarCaracteristicaDepartamento(bean);
					redirect.addFlashAttribute("MENSAJE", "Se registro el departamento correctamente, con el codigo: "
							+ bean.getIdCarateristicadepartamento());
				} else {
					bean.setIdCarateristicadepartamento(codigo);
					service.registraryactualizarCaracteristicaDepartamento(bean);
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el departamento correctamente, con el codigo: "
							+ bean.getIdCarateristicadepartamento());
				}
			}else {
				redirect.addFlashAttribute("existente", "El número del departamento ya existe: " + nroDepartamento + " ingrese otro numero.");
			}

		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en registrar los datos de caracteristicas del departamento.");
			e.printStackTrace();
		}

		return "redirect:/registro/caracteristica_Departamento";
	}

	@GetMapping("/elimi/{idCarateristicadepartamento}")
	public String eliminarCaractDepartamento(@PathVariable(value = "idCarateristicadepartamento") int id,
			RedirectAttributes redirect) {

		try {
			CaracteristicasDepartamento bean = new CaracteristicasDepartamento();
			String eliminar = "Si";
			bean.setEliminado(eliminar);
			bean.setIdCarateristicadepartamento(id);
			service.actualizarCaracteristicasDepartamento(bean);
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE",
					"Se elimino las caracteristicas del departamento con el codigo: " + id);
			e.printStackTrace();
		}

		return "redirect:/registro/caracteristica_Departamento/";
	}

}
