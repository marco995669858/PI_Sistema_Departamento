package project.departamento.com.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.departamento.com.entity.Cliente;
import project.departamento.com.entity.Departamento;
import project.departamento.com.entity.Estado;
import project.departamento.com.entity.TipoDocumento;
import project.departamento.com.entity.Usuario;
import project.departamento.com.entity.Visita;
import project.departamento.com.entity.Visitante;
import project.departamento.com.service.ControlVisitaService;
import project.departamento.com.service.VisitanteService;

@Controller
@RequestMapping("/rest/controlvisita")
public class ControlVisitaController {

	@Autowired
	private ControlVisitaService service;

	@Autowired
	private VisitanteService visitanteService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("comboVisitante", service.listarVisitanteCombo());
		model.addAttribute("comboDepartamento", visitanteService.listarDepartamento());
		model.addAttribute("comboTipoDocuemnto", visitanteService.listarTipoDocumento());
		model.addAttribute("comCliente", visitanteService.listarCliente());
		return "VisitaIngreso";
	}

	@GetMapping(value = "/buscardni")
	@ResponseBody
	public Visitante buscar(@RequestParam("dni") String dni) {
		Visitante bean = null;
		try {
			bean = visitanteService.buscarVisitantepordni(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@RequestMapping("/registrarControl")
	public String registrarControlVisitante(@RequestParam("usuario") int usuario,
			@RequestParam("visitante") int visitante, @RequestParam("fechaIngreso") String fechaIngreso,
			@RequestParam("cliente") int cliente, RedirectAttributes redirect) {
		try {

			Visita bean = new Visita();
			bean.setUsuario(new Usuario(usuario));
			bean.setVisitante(new Visitante(visitante));
			bean.setHoraIngreso(fechaIngreso);
			bean.setHoraSalida(null);
			bean.setCliente(new Cliente(cliente));
			bean.setEstado(new Estado(6));
			bean.setComentario(null);
			bean.setFechaRegistro(new Date());
			service.registraActualiza(bean);
			redirect.addFlashAttribute("MENSAJE", "Se registro la visita correctamente");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/rest/controlvisita/";
	}

	@RequestMapping("/registrar")
	public String registraActualizaVisitante(@RequestParam("codigo") int codigo,
			@RequestParam("departamento") int idDepartamento, @RequestParam("Nombres") String nombres,
			@RequestParam("Apellidos") String apellidos, @RequestParam("idTipoDocumento") int idTipoDocumento,
			@RequestParam("Documento") String documento, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("cliente") int idCliente,
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
				Optional<Visitante> buscarDniactualizar = visitanteService.buscarDocumentoactualizar(documento, codigo);
				Optional<Visitante> buscarTelefonoactualizar = visitanteService.buscarTelefonoactualizar(telefono,
						codigo);
				Optional<Visitante> buscarCorreoactualizar = visitanteService.buscarCorreoactualizar(correo, codigo);
				if (buscarDniactualizar.isPresent()) {
					redirect.addFlashAttribute("existen", "El documento que ingreso ya existe");
				} else if (buscarTelefonoactualizar.isPresent()) {
					redirect.addFlashAttribute("existen", "El telefono que ingreso ya existe");
				} else if (buscarCorreoactualizar.isPresent()) {
					redirect.addFlashAttribute("existen", "El correo que ingreso ya existe");
				} else {
					bean.setIdVisitante(codigo);
					visitanteService.registraActualizaVisitante(bean);
					redirect.addFlashAttribute("MENSAJE", "El visitante se actualizo correctamente");
				}

			} else {
				Optional<Visitante> buscarDni = visitanteService.buscarDocumento(documento);
				Optional<Visitante> buscarTelefono = visitanteService.buscarDocumento(telefono);
				Optional<Visitante> buscarCorreo = visitanteService.buscarDocumento(correo);

				if (buscarDni.isPresent()) {
					redirect.addFlashAttribute("existen", "El documento que ingreso ya existe");
				} else if (buscarTelefono.isPresent()) {
					redirect.addFlashAttribute("existen", "El telefono que ingreso ya existe");
				} else if (buscarCorreo.isPresent()) {
					redirect.addFlashAttribute("existen", "El correo que ingreso ya existe");
				} else {
					visitanteService.registraActualizaVisitante(bean);
					redirect.addFlashAttribute("MENSAJE", "El visitante se registro correctamente");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/rest/controlvisita/";
	}
}
