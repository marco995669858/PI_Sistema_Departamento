package project.departamento.com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.TipoDocumento;
import project.departamento.com.entity.Usuario;
import project.departamento.com.entity.Visitante;
import project.departamento.com.service.VisitanteService;

@Controller
@RequestMapping("/rest/visitante")
public class VisitanteController {

	@Autowired
	private VisitanteService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tabla", service.listarTodoslosVisitantes());
		model.addAttribute("comDepartamento", service.listarDepartamento());
		model.addAttribute("comTipoDocumento", service.listarTipoDocumento());
		model.addAttribute("comCliente", service.listarCliente());

		return "visitante";
	}

	@RequestMapping("/registrar")
	public String registraActualizaVisitante(@RequestParam("codigo") int codigo,
			@RequestParam("idDepartamento") int idDepartamento, @RequestParam("Nombres") String nombres,
			@RequestParam("Apellidos") String apellidos, @RequestParam("idTipoDocumento") int idTipoDocumento,
			@RequestParam("Documento") String documento, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("idCliente") int idCliente,
			@RequestParam("usuario") int usuario, RedirectAttributes redirect) {
		try {

			Visitante bean = new Visitante();
			bean.setDepartamento(new Departamento(idDepartamento));
			bean.setNombres(nombres);
			bean.setApellidos(apellidos);
			bean.setTipoDocumento(new TipoDocumento(idTipoDocumento));
			bean.setDocumento(documento);
			bean.setTelefono(telefono);
			bean.setCorreo(correo);
			bean.setCliente(new Cliente(idCliente));
			bean.setUsuario(new Usuario(usuario));
			bean.setFechaRegistro(new Date());
			if (codigo != 0) {
				List<Visitante> buscarDniactualizar = service.buscarDocumentoactualizar(documento, codigo);
				List<Visitante> buscarTelefonoactualizar = service.buscarTelefonoactualizar(telefono, codigo);
				List<Visitante> buscarCorreoactualizar = service.buscarCorreoactualizar(correo, codigo);
				if (CollectionUtils.isEmpty(buscarDniactualizar) || !CollectionUtils.isEmpty(buscarTelefonoactualizar)
						|| CollectionUtils.isEmpty(buscarCorreoactualizar)) {
					bean.setIdVisitante(codigo);
					service.registraActualizaVisitante(bean);
					redirect.addFlashAttribute("MENSAJE", "El visitante se actualizo correctamente");
				} else {
					redirect.addFlashAttribute("existen",
							"Verifique si el dni, telefono y/o correo existieran, si existen ingrese otro.");

				}

			} else {
				List<Visitante> buscarDni = service.buscarDocumento(documento);
				List<Visitante> buscarTelefono = service.buscarDocumento(telefono);
				List<Visitante> buscarCorreo = service.buscarDocumento(correo);

				if (CollectionUtils.isEmpty(buscarDni) || CollectionUtils.isEmpty(buscarTelefono)
						|| CollectionUtils.isEmpty(buscarCorreo)) {
					service.registraActualizaVisitante(bean);
					redirect.addFlashAttribute("MENSAJE", "El visitante se registro correctamente");
				} else {
					redirect.addFlashAttribute("existen",
							"Verifique si el dni, telefono y/o correo que va a actualizar ya existen, si existen ingrese otro.");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/rest/visitante/";
	}

	@RequestMapping("/buscar")
	@ResponseBody
	public Visitante buscarVisitante(@RequestParam("codigo") int codigo) {
		Visitante bean = null;
		try {
			bean = service.buscarVisitantePorCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	@RequestMapping("/eliminar")
	public String eliminarVisitante(@RequestParam("codigo") int codigo, RedirectAttributes redirect) {

		try {
			service.eliminarVisitante(codigo);
			redirect.addFlashAttribute("MENSAJE", "Se elimino el visitante");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/rest/visitante/";
	}

}
