package project.departamento.com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.Usuario;
import project.departamento.com.entity.servicios;
import project.departamento.com.service.GenerarboletaService;

@Controller
@RequestMapping("/rest/pagosServicios")
public class GenerarComprovanteController {

	@Autowired
	private GenerarboletaService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("cboDepartamento", service.listarDepartamentos());
		model.addAttribute("cboServicios", service.listarPagodeServicios());

		return "generarboleta";
	}

	@RequestMapping("/registrar")
	public String registrarBoleta(@RequestParam("tipoBoleta") String tipoboleta, @RequestParam("servicio") int servicio,
			@RequestParam("departamento") int departamento, @RequestParam("datepicker") int datepicker,
			@RequestParam("usuario") int usuario, @RequestParam("monto") double monto, RedirectAttributes redirect) {

		int mes = 0;

		try {

			DocumentoTributario bean = new DocumentoTributario();

			for (int i = 1; i <= 12; i++) {
				LocalDate monthstart = LocalDate.of(datepicker, mes + i, 1);
				LocalDate monthend = monthstart.plusDays(monthstart.lengthOfMonth() - 1);
				Optional<DocumentoTributario> buscar = service
						.buscarFechaPagoPresente(monthend.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), servicio);
				if (buscar.isPresent()) {
					redirect.addFlashAttribute("existen", "La boleta ya se genero para ese año: " + monthend);
				} else {
					System.out.println(monthend);
					bean.setIdDocTributario(0);
					bean.setIniciales(tipoboleta);
					bean.setDepartamento(new Departamento(departamento));
					bean.setMes(mes + i);
					bean.setFechaPago(monthend.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
					bean.setServicios(new servicios(servicio));
					bean.setUsuario(new Usuario(usuario));
					bean.setMonto(monto);
					bean.setEstado("No pagado");
					service.registrarDocumentoTributario(bean);
					redirect.addFlashAttribute("MENSAJE", "Se genero la boleta correctamente.");
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/pagosServicios/";
	}

}
