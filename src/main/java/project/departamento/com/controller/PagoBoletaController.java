package project.departamento.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.BoletaPago;
import project.departamento.com.entity.DocumentoTributario;
import project.departamento.com.entity.Usuario;
import project.departamento.com.service.PagoBoletaService;

@Controller
@RequestMapping("/rest/pagarboleta")
public class PagoBoletaController {

	@Autowired
	private PagoBoletaService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tablaDocuementoTributario", service.listarDocumentoTributario());
		return "pagoBoleta";
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

	@RequestMapping("/registrarboleta")
	public String actualizarDocumentoTributario(@RequestParam("codigo") int codigo,
			@RequestParam("nroOperacion") int nroOperacion, @RequestParam("nombres") String nombres,
			@RequestParam("fechapago") String fechapago, @RequestParam("monto") double monto,
			@RequestParam("pagar") double pagar, @RequestParam("usuario") int usuario, RedirectAttributes redirect) {

		double calcular = 0;
		try {

			calcular = monto - pagar;
			DocumentoTributario bean = service.buscarPorCodigo(codigo);
			if (calcular == 0) {
				bean.setEstado("Pagado");
				bean.setMonto(calcular);
				service.pagarDocumentoTributario(bean);
			} else if (calcular >= 1) {
				bean.setEstado("Pendiente");
				bean.setMonto(calcular);
				service.pagarDocumentoTributario(bean);
			}

			BoletaPago boleta = new BoletaPago();
			boleta.setIdboletapago(0);
			boleta.setOperacion(nroOperacion);
			boleta.setNombres(nombres);
			boleta.setFechaBoletaPa(fechapago);
			boleta.setTributario(new DocumentoTributario(codigo));
			boleta.setMontoPago(pagar);
			boleta.setUsuario(new Usuario(usuario));
			boleta.setFechaRegistro(new Date());
			service.registrarBoletapago(boleta);
			redirect.addFlashAttribute("MENSAJE", "Se pago el departamento correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/pagarboleta/";
	}

}
