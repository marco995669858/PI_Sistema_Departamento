package project.departamento.com.controller;

import java.util.Date;
import java.util.List;

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
		return "departamento";
	}

	@RequestMapping
	public String registra_actualiza_departamento(@RequestParam("codigo") int codigo,
			@RequestParam("edificioFK") int edificioFK, @RequestParam("piso") int piso,
			@RequestParam("nroDepartamento") int nroDepartamento, @RequestParam("areaM2") double areaM2,
			@RequestParam("tipoDepartamentoFK") int tipoDepartamentoFK, @RequestParam("estadoFK") int estadoFK,
			@RequestParam("telefono") String telefono, RedirectAttributes redirect) {
		try {

			List<Departamento> buscar = service.buscarDepartamento(nroDepartamento, telefono);

			Departamento bean = new Departamento();
			bean.setEdificio(new Edificio(edificioFK));
			bean.setPiso(piso);
			bean.setNroDepartamento(nroDepartamento);
			bean.setAreaM2(areaM2);
			bean.setTipoDepartamento(new TipoDepartamento(tipoDepartamentoFK));
			bean.setEstadoDepartamento(new EstadoDepartamento(estadoFK));
			bean.setTelefono(telefono);
			bean.setPropietariodep(new Propietariodep(Integer.parseInt(null)));
			bean.setPropietarioEsOcupante(0);
			bean.setFechaRegistro(new Date());

			if (CollectionUtils.isEmpty(buscar)) {
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
			} else {
				redirect.addFlashAttribute("MENSAJE",
						"El numero del departamento ya existe: " + nroDepartamento + " o el telefono ya existe: " + telefono);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registro/departamento/";
	}
}
