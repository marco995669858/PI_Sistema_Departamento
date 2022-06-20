package project.departamento.com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.PagodeServicios;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.PagosServiciosService;

@Controller
@RequestMapping("/rest/pagosServicios")
public class PagosServicioController {

	@Autowired
	private PagosServiciosService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("cboDepartamento", service.listarDepartamentos());
		model.addAttribute("cboServicios", service.listarPagodeServicios());
		model.addAttribute("tablaDocuementoTributario", service.listarDocumentoTributario());

		return "pagoservicios";
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
				System.out.println(monthend);
				bean.setIdDocTributario(0);
				bean.setIniciales(tipoboleta);
				bean.setDepartamento(new Departamento(departamento));
				bean.setMes(mes + i);
				bean.setFechaPago(monthend.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				bean.setServicios(new PagodeServicios(servicio));
				bean.setUsuario(new Usuario(usuario));
				bean.setMonto(monto);
				service.registrarDocumentoTributario(bean);
			}
			redirect.addFlashAttribute("MENSAJE", "Se genero la boleta correctamente.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/pagosServicios/";
	}

	@RequestMapping("/buscar")
	@ResponseBody
	public DocumentoTributario buscarMascota(@RequestParam("codigo") int codigo) {
		DocumentoTributario bean = null;
		try {
			bean = service.buscarPorCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	@RequestMapping("/actualizar")
	public String actualizarDocumentoTributario(@RequestParam("codigo") int codigo,
			@RequestParam("tipoBoleta") String tipoboleta, @RequestParam("servicio") int servicio,
			@RequestParam("departamento") int departamento, @RequestParam("usuario") int usuario,
			@RequestParam("monto") double monto, RedirectAttributes redirect) {

		try {
			DocumentoTributario bean = new DocumentoTributario();
//			bean.setIniciales(tipoboleta);
//			bean.setDepartamento(new Departamento(departamento));
//			bean.setMes();
//			bean.setFechaPago();
//			bean.setServicios(new PagodeServicios(servicio));
//			bean.setUsuario(new Usuario(usuario));
//			bean.setMonto(monto);
//			service.registrarDocumentoTributario(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/pagosServicios/";
	}
}
