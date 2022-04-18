package project.departamento.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.CaracteristicasDepartamento;
import project.departamento.com.service.CaracteristicasDepartamentoService;


@Controller
@RequestMapping("/registro/caracteristica_Departamento")
public class CaracteristicasDepartamentoController {

	@Autowired
	private CaracteristicasDepartamentoService service;
	
	
	
	//probando
	
	
	
	
	
	
	
	
	
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
