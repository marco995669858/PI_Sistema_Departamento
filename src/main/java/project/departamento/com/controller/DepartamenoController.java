package project.departamento.com.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Edificio;
import project.departamento.com.entity.EstadoDepartamento;
import project.departamento.com.entity.Propietariodep;
import project.departamento.com.entity.TipoDepartamento;
import project.departamento.com.service.DepartamentoService;

@Controller
@RequestMapping("/registro/departamento")
public class DepartamenoController {

	@Autowired
	private DepartamentoService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("edificio", service.listarEdificio());
		model.addAttribute("tipodepartamento", service.listarTipoDepartamento());
		return "departamento";
	}

	@RequestMapping("/registra_actualiza")
	public String registra_actualiza_departamento(@RequestParam("codigo") int codigo,
			@RequestParam("edificioFK") int edificioFK, @RequestParam("piso") int piso,
			@RequestParam("nroDepartamento") int nroDepartamento, @RequestParam("areaM2") double areaM2,
			@RequestParam("tipoDepartamentoFK") int tipoDepartamentoFK, @RequestParam("telefono") String telefono,
			RedirectAttributes redirect) {
		try {

			Optional<Departamento> buscarnroDepartamento = service.buscarnroDepartamento(nroDepartamento);
			Optional<Departamento> buscartelefono = service.buscarTelefono(telefono);

			if (buscarnroDepartamento.isPresent()) {
				redirect.addFlashAttribute("existente", "El numero del departamento ya existe: " + nroDepartamento);
			} else if(buscartelefono.isPresent()) {
				redirect.addFlashAttribute("existente", "El telefono ya existe: " + telefono);
			} else {
				Departamento bean = new Departamento();
				bean.setEdificioFK(new Edificio(edificioFK));
				bean.setPiso(piso);
				bean.setNroDepartamento(nroDepartamento);
				bean.setAreaM2(areaM2);
				bean.setTipoDepartamentoFK(new TipoDepartamento(tipoDepartamentoFK));
				bean.setEstadoFK(new EstadoDepartamento(2));
				bean.setTelefono(telefono);
				bean.setPropietarioFK(null);
				bean.setPropietarioEsOcupante(0);
				bean.setFechaRegistro(new Date());

				if (codigo != 0) {
					bean.setIdDepartamento(codigo);
					service.registra_actualiza_departamento(bean);
					redirect.addFlashAttribute("MENSAJE",
							"Se actualizo correctamente el numero del departamento: " + nroDepartamento);
				} else {
					service.registra_actualiza_departamento(bean);
					redirect.addFlashAttribute("MENSAJE",
							"Se registro correctamente el numero del departamento: " + nroDepartamento);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/departamento/";
	}
}
